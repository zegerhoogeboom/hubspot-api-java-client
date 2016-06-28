package farm.shangrila.hubspot.api.model;

import com.google.api.client.util.Key;

/**
 * @author Zeger Hoogeboom
 */
public class EmailMessage {
    @Key
    String to;
    @Key
    String from;
    @Key
    String replyTo;

    public String getTo() {
        return to;
    }

    public EmailMessage setTo(String to) {
        this.to = to;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public EmailMessage setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public EmailMessage setReplyTo(String replyTo) {
        this.replyTo = replyTo;
        return this;
    }
}
