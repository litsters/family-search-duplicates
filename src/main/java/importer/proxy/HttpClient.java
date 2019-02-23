package importer.proxy;

import importer.DataImportException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by Seege on 11/10/2017.
 */
public class HttpClient implements IClient{
    private static final int READ_TIMEOUT = 10000;
    private static final int CONNECT_TIMEOUT = 10000;

    public HttpClient(){ }

    /**
     * Gets a response for a URL.
     * @param url The url to try.
     * @param token The token to use as authorization in the headers.
     * @return The response for the url. If there was an error, the error is the response that will be sent. Can also
     * return null if an empty response was returned.
     * @throws DataImportException If an unexpected error occurs, it is wrapped in a DataImportException
     * and re-thrown.
     * @throws SocketTimeoutException If the url took too long to connect or to read.
     */
    @Override
    public Response get(String url, String token) throws DataImportException,SocketTimeoutException {
        try {
            // Open connection to family search
            IConnectionFactory factory = new WebFactory();
            IConnection connection = factory.openConnection(url);

            if(connection == null) throw new DataImportException("HttpClient: connection is NULL");
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            connection.setRequestProperty("Authorization",  "Bearer " + token);
            connection.setConnectTimeout(CONNECT_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.connect();

            // If response is received...
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Get response body input stream
                InputStream responseBody = connection.getInputStream();

                // Read response body bytes
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = responseBody.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }

                // Convert response body bytes to a string
                String responseBodyData = baos.toString();
                return new Response(responseBodyData);
            }
            else if(connection.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT){
                // Response has no content
                return null;
            }
            else {
                // An error was returned.
                InputStream responseBody = connection.getErrorStream();
                if(responseBody == null){
                    throw new DataImportException("HttpClient: Response body was null, response code = " + connection.getResponseCode());
                }
                String retry = connection.getHeaderField("Retry-After");

                // Read response body bytes
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length = 0;
                while ((length = responseBody.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }

                // Convert response body bytes to a string
                String responseBodyData = baos.toString();

                Response response = new Response(responseBodyData);
                if(retry != null)response.setRetry(Integer.parseInt(retry));
                return response;
            }
        }
        catch (IOException e) {
            if(e instanceof SocketTimeoutException) throw new SocketTimeoutException(e.getMessage());
            throw new DataImportException("HttpClient: ERROR! " + e.getMessage());
        }
    }
}
