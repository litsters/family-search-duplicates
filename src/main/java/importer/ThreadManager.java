package importer;

import java.util.*;

public class ThreadManager {
    private static final long DEFAULT_FREQUENCY = 1000;

    private List<ImportThread> threads;
    private int reportCounter;
    private long reportFrequency;
    private Timer timer;

    public ThreadManager(){
        threads = new ArrayList<>();
        reportCounter = 0;
        reportFrequency = DEFAULT_FREQUENCY;
        timer = null;
    }

    public void addThread(ImportThread thread){
        threads.add(thread);
    }

    public void startReporting(long reportFrequency){
        this.reportFrequency = reportFrequency;
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new StatusUpdate(this), 0, this.reportFrequency);
    }

    public void cancelReporting(){
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }

    public Iterator<ImportThread> threadIterator(){ return threads.iterator();}

    public int numThreads(){ return threads.size(); }

    private String generateReport(){
        StringBuilder report = new StringBuilder("{\n  REPORT #").append(reportCounter++).append("\n");
        for(ImportThread thread : threads){
            report.append("  ");
            report.append(thread.getId()).append(":");
            report.append(thread.getState());
            report.append(":");
            report.append(thread.getStatus());
            report.append("\n");
        }

        report.append("}\n");
        return report.toString();
    }

    private class StatusUpdate extends TimerTask{
        private ThreadManager owner;

        public StatusUpdate(ThreadManager owner){this.owner = owner;}

        @Override
        public void run() {
            System.out.println(owner.generateReport());
        }
    }
}
