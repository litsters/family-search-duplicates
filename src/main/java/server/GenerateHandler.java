package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import csvInfo.RowInfo;
import dataManagement.CSVPrinter;
import dataManagement.DataPrinter;
import importer.ImportThread;
import importer.ThreadManager;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.*;

public class GenerateHandler implements HttpHandler {
    private static final int THREAD_MULTIPLIER = 10;

    private static final String INPUT_FOLDER = "inputs/";
    private static final String INPUT_FILE = "MergeTruthSet-Final.csv";
    private static final String OUTPUT_FOLDER = "outputs/";
    private static final String AUTHORIZATION_KEY = "Authorization";
    private static final String OUTPUT_KEY = "Output";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        // Get auth token from Authorization header
        Headers headers = httpExchange.getRequestHeaders();
        String authtoken = headers.getFirst(AUTHORIZATION_KEY);
        System.out.println("authtoken: [" + authtoken + "]");

        // Get new .csv filename from headers
        String outputFilename = headers.getFirst(OUTPUT_KEY);
        System.out.println("filename: [" + outputFilename + "]");

        // Close connection
        int responseCode;
        String result;
        if(authtoken == null || outputFilename == null){
            // Necessary information missing, alert client and abort.
            responseCode = HttpURLConnection.HTTP_BAD_REQUEST;
            result = "Missing authtoken or outputfilename";
        } else {
            // Everything is ok, continuing
            responseCode = HttpURLConnection.HTTP_OK;
            result = "Process good";
        }
        httpExchange.sendResponseHeaders(responseCode, 0);
        OutputStream os = httpExchange.getResponseBody();
        os.write(result.getBytes());
        os.close();

        // Gather and process data
        try{
            List<RowInfo> rows = extractData();
            processData(rows, OUTPUT_FOLDER + outputFilename, authtoken);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Process complete");
    }

    private List<RowInfo> extractData() throws Exception{
        // Open .csv
        File input = new File(INPUT_FOLDER + INPUT_FILE);
        Scanner scanner = new Scanner(new FileReader(input));
        scanner.nextLine();     // Throw away first line, since I don't care

        List<RowInfo> rows = new ArrayList<>();
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] cells = line.split("(?<=,)");
            RowInfo row = new RowInfo(cells);
            rows.add(row);
        }

        scanner.close();

        return rows;
    }

    private List<List<RowInfo>> partitionData(List<RowInfo> data, int numPartitions){
        List<List<RowInfo>> partitions = new ArrayList<>();

        // Determine chunk size
        int chunkSize = (int)Math.ceil((double)data.size() / (double)numPartitions);

        // Split up data
        for(int i = 0; i < numPartitions; ++i){
            List<RowInfo> partition = new ArrayList<>();
            for(int j = 0; j < chunkSize; ++j){
                try{
                    RowInfo row = data.get((i*chunkSize) + j);
                    partition.add(row);
                }catch(IndexOutOfBoundsException e){
                    // This is expected; no worries.
                    break;
                }
            }
            partitions.add(partition);
        }

        return partitions;
    }

    private int numProcessors(int numRows){
        int numThreads = Runtime.getRuntime().availableProcessors() * THREAD_MULTIPLIER;
        if(numThreads > numRows) numThreads = numRows;
        return numThreads;
    }

    private void processData(List<RowInfo> rows, String outputFilename, String token) throws IOException{
        // Prepare data printer
        String[] headers = new String[]{"PID1","PID2","B1","B2","PB","D1","D2","PD","PRODUCT","AVERAGE","DUPLICATE"};
        DataPrinter dataPrinter = new CSVPrinter(outputFilename, Arrays.asList(headers));

        // Divide data up into chunks for paralellization
        int numThreads = numProcessors(rows.size());
        List<List<RowInfo>> partitions = partitionData(rows, numThreads);

        // For each partition, create a thread
        ThreadManager threadManager = new ThreadManager();
        for(List<RowInfo> partition : partitions){
            ImportThread thread = new ImportThread(token, partition, dataPrinter);
            thread.start();
            threadManager.addThread(thread);
        }
        threadManager.startReporting(1000);

        // Wait for each thread to finish
        List<String> errors = new ArrayList<>();
        Iterator<ImportThread> threadIterator = threadManager.threadIterator();
        while(threadIterator.hasNext()){
            ImportThread thread = threadIterator.next();
            try{
                thread.join();

                // Check for error
                if(thread.getError() != null){
                    errors.add("Error in thread " + thread.getId() + ": " + thread.getError().getMessage());
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        threadManager.cancelReporting();
        for(String error : errors) System.err.println(error);
        System.out.println("Done gathering data from family search");

        // Print tuples to new .csv
        dataPrinter.print();
        System.out.println("Output file generated");
    }
}
