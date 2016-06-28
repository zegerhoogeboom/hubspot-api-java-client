package farm.shangrila.hubspot.api.model;

import com.google.api.client.util.Key;

/**
 * @author Zeger Hoogeboom
 */
public class EmailProperty {
    @Key
    private String name;
    @Key
    private String value;

    public EmailProperty() {
    }

    public EmailProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
