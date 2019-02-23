package csvInfo;

import java.util.ArrayList;
import java.util.List;

public class RowInfo {
    private static final int NUM_COLUMNS = 13;
    private static final int NUM_DUPLICATE_COLUMNS = 8;

    private String basePid;
    private List<String> duplicates;
    private List<String> notDuplicates;

    public RowInfo(String[] csvLine) throws Exception{
        if(csvLine.length < NUM_COLUMNS) throw new Exception("Unexpected number of columns");
        basePid = strip(csvLine[0]);
        duplicates = new ArrayList<>();
        for(int i = 1; i <= NUM_DUPLICATE_COLUMNS; ++i){
            String pid = strip(csvLine[i]);
            if(!pid.equals("")) duplicates.add(pid);
        }
        notDuplicates = new ArrayList<>();
        for(int i = NUM_DUPLICATE_COLUMNS + 1; i < csvLine.length; ++i){
            String pid = strip(csvLine[i]);
            if(!pid.equals("")) notDuplicates.add(pid);
        }
    }

    public String strip(String original){
        return original.replaceAll(",", "").replaceAll("\\s", "");
    }

    public String getBasePid() {
        return basePid;
    }

    public List<String> getDuplicates() {
        return duplicates;
    }

    public List<String> getNotDuplicates() {
        return notDuplicates;
    }

    @Override
    public String toString(){
        return "[ Base:" + basePid + ", Duplicates:" + duplicates.toString() + ", Not Duplicates:" + notDuplicates.toString() + " ]";
    }
}
