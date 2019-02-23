package importer.proxy;

import importer.DataImportException;

import java.net.SocketTimeoutException;

public interface IClient {
    public Response get(String url, String token) throws DataImportException,SocketTimeoutException;
}
