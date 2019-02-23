package importer.proxy;


import familySearchModel.extensibleData.hypermediaEnabledData.gedcomx.FamilySearchPlatform;
import importer.DataImportException;
import importer.ImportThread;
import serialization.SerializeException;
import serialization.Serializer;

import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Objects;

import static java.lang.Thread.sleep;

/**
 * Handles calls to the Family Search servers.
 */
public class FamilySearchProxy implements IProxy{
    private static final String BASE = "https://api.familysearch.org";
    private static final int MAX_TIMEOUTS = 20;

    private IClient connection;
    private ImportThread thread;

    public FamilySearchProxy(){
        connection = new HttpClient();
        thread = null;
    }

    @Override
    public void setThread(ImportThread thread){this.thread = thread;}

    /**
     * Converts a token into the proper parameter for a URL
     * @param token A FamilySearch token.
     * @return The parameter for a URL using the token.
     */
    private String getTokenParam(String token){
        return "?access_token=" + token;
    }

    /**
     * Converts a Response body to a FamilySearchPlatform.
     * @param response The Response containing a FamilySearchPlatform.
     * @return Obvious.
     */
    private FamilySearchPlatform responseToPlatform(Response response){
        try {
            if (response == null) return null;
            return (FamilySearchPlatform) Serializer.get().deserialize(response.getBody(), FamilySearchPlatform.class);
        }catch(SerializeException e){
//            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets a response for a url from Family Search.  This method WILL block the thread!
     * If the response times out, will retry up to as many times as the max is. If the request
     * is throttled, will sleep the thread for the duration of the timeout and then try again.
     * @param url The URL to use in the request to family search.
     * @param token The authorization token for family search.
     * @return The Response to the request sent to Family Search.
     * @throws DataImportException If there is an error while processing the response, or if
     * it times out too many times.
     */
    private Response getResponse(String url, String token) throws DataImportException {
        int timeouts = 0;
        while(true){
            try{
                // Get response
                if(thread != null)thread.setDetails("Waiting for response");
                Response response = connection.get(url,token);
                if(response == null){
                    return null;
                }

                // If response was throttled, wait and retry.
                if(response.getRetry() > 0){
                    timeouts = 0;
                    if(thread != null) thread.setThrottled(response.getRetry());
                    if(thread != null) thread.setDetails("Sleeping");
                    sleep(response.getRetry() * 1000);
                }
                else{
                    if(thread != null) thread.setThrottled(-1);
                    if(thread != null) thread.setDetails(null);
                    return response;
                }
            }catch(SocketTimeoutException e){
                // The response timed out...
                ++timeouts;
                if(thread != null) thread.setThrottled(-1);
                if(thread != null) thread.setDetails(null);
                if (timeouts > MAX_TIMEOUTS) {
                    if (thread != null) thread.setDetails("Timed out too many times");
                    return null;
                }
            }catch(Exception e){
                if(e instanceof InterruptedException) Thread.currentThread().interrupt();
                else if(e instanceof DataImportException) throw (DataImportException)e;
            }
        }
    }

    /**
     * Gets the ancestry for a person. Will block until the request is answered successfully.
     * @param pid The PID of the person.
     * @param token The token of the user making the request.
     * @param generations The number of generations to get.
     * @return Obvious.
     * @throws DataImportException If there are too many timeouts, or errors occur while reading data.
     */
    @Override
    public FamilySearchPlatform getAncestry(String pid, String token, int generations) throws DataImportException {
        String url = BASE + "/platform/tree/ancestry" + getTokenParam(token) +
                "&generations=" + generations + "&person=" + pid;
        Response response = getResponse(url, token);
        return responseToPlatform(response);
    }

    /**
     * Gets the spouses for a person. Will block until the request is answered successfully.
     * @param pid The PID of the person.
     * @param token The token of the user making the request.
     * @return Obvious.
     * @throws DataImportException If there are too many timeouts, or errors occur while reading data.
     */
    @Override
    public FamilySearchPlatform getSpouses(String pid, String token) throws DataImportException{
        String url = BASE + "/platform/tree/persons/" + pid + "/spouses" + getTokenParam(token);
        Response response = getResponse(url,token);
        return responseToPlatform(response);
    }

    /**
     * Gets the children for a person. Will block until the request is answered successfully.
     * @param pid The PID of the person.
     * @param token The token of the user making the request.
     * @return Obvious.
     * @throws DataImportException If there are too many timeouts, or errors occur while reading data.
     */
    @Override
    public FamilySearchPlatform getChildren(String pid, String token) throws DataImportException{
        String url = BASE + "/platform/tree/persons/" + pid + "/children" + getTokenParam(token);
        Response response = getResponse(url,token);
        return responseToPlatform(response);
    }

    /**
     * Gets the parents for a person. Will block until the request is answered successfully.
     * @param pid The PID of the person.
     * @param token The token of the user making the request.
     * @return Obvious.
     * @throws DataImportException If there are too many timeouts, or errors occur while reading data.
     */
    @Override
    public FamilySearchPlatform getParents(String pid, String token) throws DataImportException{
        String url = BASE + "/platform/tree/persons/" + pid + "/parents" + getTokenParam(token);
        Response response = getResponse(url, token);
        return responseToPlatform(response);
    }

    /**
     * Gets the details for a person. Will block until the request is answered successfully.
     * @param pid The PID of the person.
     * @param token The token of the user making the request.
     * @return Obvious.
     * @throws DataImportException If there are too many timeouts, or errors occur while reading data.
     */
    @Override
    public FamilySearchPlatform getDetails(String pid, String token) throws DataImportException{
        String url = BASE + "/platform/tree/persons/" + pid + getTokenParam(token);
        Response response = getResponse(url,token);
        return responseToPlatform(response);
    }


    /**
     * Gets the current user associated with a token. Will block until the request is answered successfully.
     * @param token The token of the user making the request.
     * @return Obvious.
     * @throws DataImportException If there are too many timeouts, or errors occur while reading data.
     */
    @Override
    public FamilySearchPlatform getCurrentUser(String token) throws DataImportException{
        String url = BASE + "/platform/users/current" + getTokenParam(token);
        Response response = getResponse(url,token);
        return responseToPlatform(response);
    }
}
