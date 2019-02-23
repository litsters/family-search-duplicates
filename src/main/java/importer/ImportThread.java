package importer;


import csvInfo.RowInfo;
import dataManagement.DataPrinter;
import dataManagement.Tuple;
import dataManagement.features.FeatureMaker;
import dataManagement.features.fhtl.LabFeatureMaker;
import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;
import importer.proxy.FamilySearchProxy;
import importer.proxy.IProxy;

import java.util.List;


/**
 * Gathers all the information for a family--a person, their spouses, and their children.
 */
public class ImportThread {
    private static int ID_COUNTER = 0;

    private IProxy proxy;
    private String token;
    private Exception error;
    private String status;
    private String details;
    private int throttled;
    private boolean keepRunning;

    private Thread thread;
    private String id;
    private List<RowInfo> partition;
    private DataPrinter dataPrinter;

    public ImportThread(String token, List<RowInfo> partition, DataPrinter dataPrinter){
        id = Integer.toString(ID_COUNTER++);
        this.proxy = new FamilySearchProxy();
        this.token = token;
        this.error = null;
        status = "Created";
        throttled = -1;
        details = null;
        keepRunning = true;
        thread = null;
        this.partition = partition;
        this.dataPrinter = dataPrinter;
    }

    /**
     * Tells the thread to stop running.
     */
    public void kill(){
        keepRunning = false;
    }

    /**
     * Gets a string describing the status of the thread.
     * @return Obvious.
     */
    public String getStatus(){
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(":");
        if(this.thread != null) sb.append(this.thread.getState()).append(":");
        sb.append(status);
        if(throttled >= 0) sb.append(":THROTTLED=").append(throttled);
        if(details != null) sb.append(":DETAILS=").append(details);
        return sb.toString();
    }

    /**
     * Sets the 'details' component of the status, used to describe in greater detail what the thread is doing.
     * @param details The string to set as 'details.'
     */
    public void setDetails(String details){this.details = details;}

    /**
     * Tells how long the thread has been throttled for.
     * @return The number of seconds the thread has been throttled for, or -1 if it's not currently throttled.
     */
    public int getThrottled(){return throttled;}

    /**
     * Sets the time the thread has been throttled for.
     * @param throttledLength The number of seconds the thread has been throttled for, or -1 if the thread is not currently throttled.
     */
    public void setThrottled(int throttledLength){throttled = throttledLength;}

    /**
     * Returns a DataImport Exception that was thrown during the normal execution of the thread.
     * @return An error describing what went wrong during the import process, or null if no such error occurred.
     */
    public Exception getError(){return error;}


    /**
     * Downloads and stores the data on a family: an ancestor, all their spouses, and all their children.
     */

    public void start() {
        thread = new Thread(() -> {
            this.status = "beginning";

            try {
                this.proxy.setThread(this); // Hooks up to the proxy
                FeatureMaker featureMaker = new LabFeatureMaker();

                // Set up progress tracking information
                int numRows = partition.size();
                int numRowsComplete = 0;

                // For each row
                for (RowInfo rowInfo : partition) {
                    // Check flag
                    if(!keepRunning) return;

                    status = "Beginning work on row " + numRowsComplete + "/" + numRows;

                    // Get base person info
                    String basePid = rowInfo.getBasePid();
                    FamilySearchPlatform basePersonData = this.proxy.getDetails(basePid, token);
                    if(basePersonData == null || basePersonData.getPersons() == null){
                        throw new Exception("Failed to get base person: [" + basePid + "]");
                    }

                    // Process matches
                    if(!keepRunning) return;    // Check flag
                    processGroup(rowInfo.getDuplicates(), basePersonData, numRows, numRowsComplete, featureMaker, rowInfo, true);

                    // Process not matches
                    if(!keepRunning) return;    // Check flag
                    processGroup(rowInfo.getNotDuplicates(), basePersonData, numRows, numRowsComplete, featureMaker, rowInfo, false);

                    ++numRowsComplete;
                    status = "Completed row " + numRowsComplete + "/" + numRows;
                }
                status = "Finished";
            }catch(Exception e){
                status = "EXCEPTION";
                this.error = e;
            }
        });
        thread.start();
    }

    private void processGroup(List<String> group, FamilySearchPlatform basePersonData, int numRows, int numRowsComplete, FeatureMaker featureMaker, RowInfo rowInfo, boolean duplicate) throws Exception{
        int numToDo = group.size();
        int complete = 0;
        for(String duplicatePid : group){
            if(duplicate) status = "Working on row " + numRowsComplete + "/" + numRows + "; working on duplicate " + complete + "/" + numToDo;
            else status = "Working on row " + numRowsComplete + "/" + numRows + "; working on not duplicate " + complete + "/" + numToDo;

            // Get match info
            FamilySearchPlatform duplicatePersonData = this.proxy.getDetails(duplicatePid, token);

            // Generate tuple
            try {
                Tuple tuple = featureMaker.makeTuple(basePersonData, duplicatePersonData, rowInfo);
                dataPrinter.addRow(tuple);
            }catch(Exception e){
                // Don't break!
            }

            ++complete;
            if(duplicate) status = "Working on row " + numRowsComplete + "/" + numRows + "; completed duplicate " + complete + "/" + numToDo;
            else status = "Working on row " + numRowsComplete + "/" + numRows + "; completed not duplicate " + complete + "/" + numToDo;
        }
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    public Thread.State getState() {
        return thread != null ? thread.getState() : null;
    }

    public String getId(){ return id; }
}
