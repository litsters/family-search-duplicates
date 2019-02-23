package dataManagement;

import java.io.IOException;
import java.io.OutputStream;

public class Value {
    private Object value;

    public Value(Object value){ this.value = value; }

    public Object getValue(){ return this.value; }

    public void write(OutputStream os) throws IOException {
        if(this.value != null){
            String output = this.value.toString() + ",";
            os.write(output.getBytes());
        }
    }
}
