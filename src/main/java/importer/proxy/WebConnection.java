package importer.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * This class functions as a wrapper to make testing the whole system easier.
 */
public class WebConnection implements IConnection {
    private HttpURLConnection connection;

    public WebConnection(HttpURLConnection e){
        this.connection = e;
    }

    @Override
    public void setRequestMethod(String method) throws IOException{
        connection.setRequestMethod(method);
    }

    @Override
    public void setRequestProperty(String key, String property) {
        connection.setRequestProperty(key, property);
    }

    @Override
    public void setConnectTimeout(int timeout) {
        connection.setConnectTimeout(timeout);
    }

    @Override
    public void setReadTimeout(int timeout) {
        connection.setReadTimeout(timeout);
    }

    @Override
    public void connect() throws IOException {
        connection.connect();
    }

    @Override
    public int getResponseCode() throws IOException{
        return connection.getResponseCode();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return connection.getInputStream();
    }

    @Override
    public InputStream getErrorStream() throws IOException {
        return connection.getErrorStream();
    }

    @Override
    public String getHeaderField(String field) {
        return connection.getHeaderField(field);
    }
}
