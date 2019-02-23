package importer.proxy;

import java.io.IOException;
import java.io.InputStream;

/**
 * Extension of HttpUrlConnection
 */
public interface IConnection {
    public void setRequestMethod(String method) throws IOException;
    public void setRequestProperty(String key, String property);
    public void setConnectTimeout(int timeout);
    public void setReadTimeout(int timeout);
    public void connect() throws IOException;
    public int getResponseCode() throws IOException;
    public InputStream getInputStream() throws IOException;
    public InputStream getErrorStream() throws IOException;
    public String getHeaderField(String field);
}