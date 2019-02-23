package importer.proxy;

/**
 * This is a response from Family Search. If retry is not -1, it means the request was throttled and you need
 * to wait the length of the retry before trying the request again.
 */
public class Response {
    String body;
    int retry;

    public Response(String body){
        this.body = body;
        retry = -1;
    }

    public Response(String body, int retry){
        this.body = body;
        this.retry = retry;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }
}
