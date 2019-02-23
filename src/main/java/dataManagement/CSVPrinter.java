package dataManagement;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class CSVPrinter extends DataPrinter {
    private List<String> columnHeaders;

    public CSVPrinter(String outputFilename, List<String> columnHeaders) {
        super(outputFilename);
        this.columnHeaders = columnHeaders;
    }

    @Override
    public void printHeader(OutputStream os) throws IOException {
        StringBuilder headerRow = new StringBuilder();
        for(String column : columnHeaders){
            headerRow.append(column);
            headerRow.append(",");
        }
        headerRow.append("\n");
        os.write(headerRow.toString().getBytes());
    }

    @Override
    public void printFooter(OutputStream os) throws IOException {
        // Do nothing; CSV files have no footer.
    }
}
