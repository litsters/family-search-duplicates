package dataManagement;

import java.io.IOException;
import java.io.OutputStream;

public class CSVTuple extends Tuple {
    @Override
    public void printHeader(OutputStream os) throws IOException {
        // Do nothing; CSV rows don't have a header
    }
}
