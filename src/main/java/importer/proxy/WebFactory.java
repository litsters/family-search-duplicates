package importer.proxy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Connects to the given url and returns that connection.
 */
public class WebFactory implements IConnectionFactory {
    @Override
    public IConnection openConnection(String url) throws IOException {
        URL target = new URL(url);
        HttpURLConnection connection = (HttpURLConnection)target.openConnection();
        return new WebConnection(connection);
    }
}
