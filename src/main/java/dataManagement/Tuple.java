package dataManagement;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Tuple {
    private List<Value> values;

    public Tuple(){
        values = new ArrayList<>();
    }

    public void addValue(Value value){values.add(value);}

    public void addValues(Value... newValues){
        values.addAll(Arrays.asList(newValues));
    }

    public void print(OutputStream os) throws IOException{
        // Print row header
        printHeader(os);

        for(Value val : values){
            if(val != null) val.write(os);
        }
        String endLine = "\n";
        os.write(endLine.getBytes());
    }

    public abstract void printHeader(OutputStream os) throws IOException;
}
