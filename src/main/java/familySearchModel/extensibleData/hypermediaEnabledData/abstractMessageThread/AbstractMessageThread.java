package familySearchModel.extensibleData.hypermediaEnabledData.abstractMessageThread;

import familySearchModel.extensibleData.hypermediaEnabledData.Agent;
import familySearchModel.extensibleData.hypermediaEnabledData.HypermediaEnabledData;

/**
 * A representation of attributes associated with a message thread that are shared among more than one concrete class.
 * Note that the id in the ExtensibleData base class is the message thread id.
 */
public class AbstractMessageThread extends HypermediaEnabledData {
    private Agent author;           // Get the author of this message thread.
    private Agent[] participants;   // Get the participants in this message thread. Note that the author is considered a participant by default and is not included in the list of participants.
    private String subject;         // Get the subject of this message thread.
    private String about;           // Get the name of the tree person this message thread is about.
    private String aboutUri;        // Get the URI for the tree person this message thread is about.
    private double lastModified;    // Get the date/time that this message thread was last modified.

    public AbstractMessageThread(){
        super();
        author = null;
        participants = null;
        subject = null;
        about = null;
        aboutUri = null;
        lastModified = -1;
    }

    public Agent getAuthor() {
        return author;
    }

    public void setAuthor(Agent author) {
        this.author = author;
    }

    public Agent[] getParticipants() {
        return participants;
    }

    public void setParticipants(Agent[] participants) {
        this.participants = participants;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAboutUri() {
        return aboutUri;
    }

    public void setAboutUri(String aboutUri) {
        this.aboutUri = aboutUri;
    }

    public double getLastModified() {
        return lastModified;
    }

    public void setLastModified(double lastModified) {
        this.lastModified = lastModified;
    }
}
