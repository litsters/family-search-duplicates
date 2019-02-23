package dataManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DataPrinter {
    private String outputFilename;
    private List<Tuple> rows;

    public DataPrinter(String outputFilename){
        this.outputFilename = outputFilename;
        this.rows = new ArrayList<>();
    }

    public void addRow(Tuple row){
        rows.add(row);
    }

    public void print() throws IOException {
        // Open file output stream
        FileOutputStream fos = new FileOutputStream(new File(this.outputFilename));

        // Print headers
        printHeader(fos);

        // Print data
        for(Tuple row : rows) row.print(fos);

        // Print footer
        printFooter(fos);

        // Close output file
        fos.close();
    }

    protected abstract void printHeader(OutputStream os) throws IOException;
    protected abstract void printFooter(OutputStream os) throws IOException;
}
