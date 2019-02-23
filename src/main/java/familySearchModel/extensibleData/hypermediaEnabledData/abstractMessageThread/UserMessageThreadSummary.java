package familySearchModel.extensibleData.hypermediaEnabledData.abstractMessageThread;

/**
 * Class that contains a summary of a message thread that a user is participating in.
 * Note that the id is the id of the message thread whose counters are represented.
 */
public class UserMessageThreadSummary extends AbstractMessageThread {
    private String userId;          // Get the id of the user that this user message thread summary is for.
    private int messageCount;       // Get the number of messages in all of the message threads this user is participating in.
    private int unreadMessageCount; // Get the number of unread messages in all of the message threads this user is participating in.

    public UserMessageThreadSummary(){
        super();
        userId = null;
        messageCount = -1;
        unreadMessageCount = -1;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    public int getUnreadMessageCount() {
        return unreadMessageCount;
    }

    public void setUnreadMessageCount(int unreadMessageCount) {
        this.unreadMessageCount = unreadMessageCount;
    }
}
