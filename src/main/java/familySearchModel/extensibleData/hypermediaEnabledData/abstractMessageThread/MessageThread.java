package familySearchModel.extensibleData.hypermediaEnabledData.abstractMessageThread;

import familySearchModel.extensibleData.hypermediaEnabledData.Message;

/**
 * A thread of related messages.
 */
public class MessageThread extends AbstractMessageThread {
    private Message[] messages; // Get the messages associated with this message thread.

    public MessageThread(){
        super();
        messages = null;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
