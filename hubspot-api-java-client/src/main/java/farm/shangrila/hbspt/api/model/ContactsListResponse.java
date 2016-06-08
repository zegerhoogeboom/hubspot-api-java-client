package farm.shangrila.hbspt.api.model;

import java.util.List;

public class ContactsListResponse {

    @com.google.api.client.util.Key("has-more")
    private Boolean hasMore;
    @com.google.api.client.util.Key("vid-offset")
    private Integer offset;
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

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
