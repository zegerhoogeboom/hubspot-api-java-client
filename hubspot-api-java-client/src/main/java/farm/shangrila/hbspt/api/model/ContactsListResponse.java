package farm.shangrila.hbspt.api.model;

import java.util.List;

public class ContactsListResponse {

    @com.google.api.client.util.Key
    private List<ContactsResponse> contacts;

    public ContactsListResponse() {
    }

    public List<ContactsResponse> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactsResponse> contacts) {
        this.contacts = contacts;
    }
}
