package familySearchModel.extensibleData.hypermediaEnabledData;

import familySearchModel.extensibleData.hypermediaEnabledData.abstractMessageThread.UserMessageThreadSummary;

/**
 * Class that contains summary information for all message threads that a user is participating in and
 * a list of userMessageThreadSummary for each of those threads. Note that the id is not used.
 */
public class UserMessageThreadsSummary extends HypermediaEnabledData {
    private String userId;                                          // Get the id of the user that this user message thread summary is for.
    private int messageCount;                                       // Get the number of messages in all of the message threads this user is participating in.
    private int unreadMessageCount;                                 // Get the number of unread messages in all of the message threads this user is participating in.
    private int threadCount;                                        // Get the number of message threads this user is participating in.
    private int unreadThreadCount;                                  // Get the number of unread message threads this user is participating in.
    private UserMessageThreadSummary[] userMessageThreadSummaries;  // Get the thread userMessageThreadSummary of message threads this user is participating in.

    public UserMessageThreadsSummary(){
        super();
        userId = null;
        messageCount = -1;
        unreadMessageCount = -1;
        threadCount = -1;
        unreadThreadCount = -1;
        userMessageThreadSummaries = null;
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

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getUnreadThreadCount() {
        return unreadThreadCount;
    }

    public void setUnreadThreadCount(int unreadThreadCount) {
        this.unreadThreadCount = unreadThreadCount;
    }

    public UserMessageThreadSummary[] getUserMessageThreadSummaries() {
        return userMessageThreadSummaries;
    }

    public void setUserMessageThreadSummaries(UserMessageThreadSummary[] userMessageThreadSummaries) {
        this.userMessageThreadSummaries = userMessageThreadSummaries;
    }
}
