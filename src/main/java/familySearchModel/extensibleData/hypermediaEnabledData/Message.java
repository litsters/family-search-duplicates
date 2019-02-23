package familySearchModel.extensibleData.hypermediaEnabledData;

/**
 * A single message.
 */
public class Message extends HypermediaEnabledData {
    private Agent author;   // Get the author of this message.
    private String body;    // Get the message body of this message.
    private double created; // Get the date/time this message was created.

    public Message(){
        super();
        author = null;
        body = null;
        created = -1;
    }

    public Agent getAuthor() {
        return author;
    }

    public void setAuthor(Agent author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }
}
