package farm.shangrila.hubspot.api.model;

import com.google.api.client.util.Key;

import java.util.List;

/**
 * @author Zeger Hoogeboom
 */
public class SingleEmail {

    @Key
    private String emailId;
    @Key
    private EmailMessage message;
    @Key
    private List<EmailProperty> contactProperties;
    @Key
    private List<EmailProperty> customProperties;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public EmailMessage getMessage() {
        return message;
    }

    public void setMessage(EmailMessage message) {
        this.message = message;
    }

    public List<EmailProperty> getContactProperties() {
        return contactProperties;
    }

    public void setContactProperties(List<EmailProperty> contactProperties) {
        this.contactProperties = contactProperties;
    }

    public List<EmailProperty> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(List<EmailProperty> customProperties) {
        this.customProperties = customProperties;
    }
}
