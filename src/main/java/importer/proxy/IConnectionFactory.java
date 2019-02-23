package importer.proxy;

import java.io.IOException;

/**
 * Makes a connection
 */
public interface IConnectionFactory {
    public IConnection openConnection(String url) throws IOException;
}
