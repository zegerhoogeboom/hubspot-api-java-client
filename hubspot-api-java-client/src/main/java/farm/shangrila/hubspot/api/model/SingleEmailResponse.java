package farm.shangrila.hubspot.api.model;

import com.google.api.client.util.Key;

/**
 * @author Zeger Hoogeboom
 */
public class SingleEmailResponse {

    public enum SendResult {
        SENT, QUEUED, PORTAL_SUSPENDED, INVALID_TO_ADDRESS, BLOCKED_DOMAIN, PREVIOUSLY_BOUNCED, PREVIOUS_SPAM, INVALID_FROM_ADDRESS, MISSING_CONTENT;
    }

    @Key
    private String message;
    @Key
    private String id;
    @Key
    private SendResult sendResult;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SendResult getSendResult() {
        return sendResult;
    }

    public void setSendResult(SendResult sendResult) {
        this.sendResult = sendResult;
    }
}
