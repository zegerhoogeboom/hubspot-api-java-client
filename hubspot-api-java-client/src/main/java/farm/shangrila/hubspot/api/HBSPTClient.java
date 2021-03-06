package farm.shangrila.hubspot.api;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.util.Preconditions;
import farm.shangrila.hubspot.api.model.*;

import java.io.IOException;

public class HBSPTClient extends AbstractGoogleJsonClient {

    public static final String DEFAULT_ROOT_URL = "https://api.hubapi.com";
    public static final String DEFAULT_SERVICE_PATH = "";
    public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

    public HBSPTClient(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
                       HBSPTHttpRequestInitializer httpRequestInitializer) {
        this(new Builder(transport, jsonFactory, httpRequestInitializer));
    }

    HBSPTClient(Builder builder) {
        super(builder);
    }

    public OwnersClient ownersClient() {
        return new OwnersClient();
    }

    public class OwnersClient {

        public Get get() throws java.io.IOException {
            Get result = new Get();
            initialize(result);
            return result;
        }

        public class Get extends HBSPTRequest<farm.shangrila.hubspot.api.model.Owners[]> {

            private static final String REST_PATH = "owners/v2/owners/";

            @com.google.api.client.util.Key
            private java.lang.String email;

            protected Get() {
                super(HBSPTClient.this, "GET", REST_PATH, null, farm.shangrila.hubspot.api.model.Owners[].class);
            }

            public java.lang.String getEmail() {
                return email;
            }

            public Get setEmail(java.lang.String email) {
                this.email = email;
                return this;
            }
        }

    }

    public CalendarsClient calendarsClient() {
        return new CalendarsClient();
    }

    public class CalendarsClient {

        public Insert insert(farm.shangrila.hubspot.api.model.Calendars content) throws java.io.IOException {
            Insert result = new Insert(content);
            initialize(result);
            return result;
        }

        public class Insert extends HBSPTRequest<farm.shangrila.hubspot.api.model.Calendars> {

            private static final String REST_PATH = "calendar/v1/events/task";

            protected Insert(farm.shangrila.hubspot.api.model.Calendars content) {
                super(HBSPTClient.this, "POST", REST_PATH, content, farm.shangrila.hubspot.api.model.Calendars.class);
            }

        }
    }

    public SingleEmailClient singleEmailClient() {
        return new SingleEmailClient();
    }

    public class SingleEmailClient {

        public Send send(SingleEmail content) throws java.io.IOException {
            Send result = new Send(content);
            initialize(result);
            return result;
        }

        public class Send extends HBSPTRequest<SingleEmailResponse> {

            private static final String REST_PATH = "email/public/v1/singleEmail/send";

            protected Send(SingleEmail content) {
                super(HBSPTClient.this, "POST", REST_PATH, content, SingleEmailResponse.class);
            }

        }
    }

    public ContactsClient contactsClient() {
        return new ContactsClient();
    }

    public class ContactsClient {

        public Get get(String contactId) throws java.io.IOException {
            Get result = new Get(contactId);
            initialize(result);
            return result;
        }

        public class Get extends HBSPTRequest<farm.shangrila.hubspot.api.model.ContactsResponse> {

            private static final String REST_PATH = "contacts/v1/contact/vid/{contactId}/profile";

            @com.google.api.client.util.Key
            private java.lang.String contactId;

            protected Get(String contactId) {
                super(HBSPTClient.this, "GET", REST_PATH, null, farm.shangrila.hubspot.api.model.ContactsResponse.class);
                this.contactId = ((String) Preconditions.checkNotNull(contactId, "Required parameter contactId must be specified."));
            }

        }

        public GetByEmail getByEmail(String email) throws java.io.IOException {
            GetByEmail result = new GetByEmail(email);
            initialize(result);
            return result;
        }

        public class GetByEmail extends HBSPTRequest<farm.shangrila.hubspot.api.model.ContactsResponse> {

            private static final String REST_PATH = "contacts/v1/contact/email/{email}/profile";

            @com.google.api.client.util.Key
            private java.lang.String email;

            protected GetByEmail(String email) {
                super(HBSPTClient.this, "GET", REST_PATH, null, farm.shangrila.hubspot.api.model.ContactsResponse.class);
                this.email = ((String) Preconditions.checkNotNull(email, "Required parameter contactId must be specified."));
            }

        }

        public Update update(String contactId, farm.shangrila.hubspot.api.model.Contacts content) throws java.io.IOException {
            Update result = new Update(contactId, content);
            initialize(result);
            return result;
        }

        public class Update extends HBSPTRequest<farm.shangrila.hubspot.api.model.VoidResponse> {

            @com.google.api.client.util.Key
            private java.lang.String contactId;

            private static final String REST_PATH = "contacts/v1/contact/vid/{contactId}/profile";

            protected Update(String contactId, farm.shangrila.hubspot.api.model.Contacts content) {
                super(HBSPTClient.this, "POST", REST_PATH, content, farm.shangrila.hubspot.api.model.VoidResponse.class);
                this.contactId = ((String) Preconditions.checkNotNull(contactId,
                        "Required parameter contactId must be specified."));
            }

        }

        public Insert insert(farm.shangrila.hubspot.api.model.Contacts content) throws java.io.IOException {
            Insert result = new Insert(content);
            initialize(result);
            return result;
        }

        public class Insert extends HBSPTRequest<farm.shangrila.hubspot.api.model.ContactsResponse> {

            private static final String REST_PATH = "contacts/v1/contact";

            protected Insert(farm.shangrila.hubspot.api.model.Contacts content) {
                super(HBSPTClient.this, "POST", REST_PATH, content, farm.shangrila.hubspot.api.model.ContactsResponse.class);
            }

        }

    }

    public ContactsList contactsList() {
        return new ContactsList();
    }

    public class ContactsList {

        public ContactsList.GetContacts contacts(String listId) throws java.io.IOException {
            ContactsList.GetContacts result = new ContactsList.GetContacts(listId);
            initialize(result);
            return result;
        }

        public class GetContacts extends HBSPTRequest<ContactsListResponse> {

            private static final String REST_PATH = "contacts/v1/lists/{listId}/contacts/all";//"contacts/v1/contact/vid/{listId}/profile";

            @com.google.api.client.util.Key
            private java.lang.String listId;

            protected GetContacts(String listId) {
                super(HBSPTClient.this, "GET", REST_PATH, null, ContactsListResponse.class);
                this.listId = ((String) Preconditions.checkNotNull(listId,
                        "Required parameter listId must be specified."));
            }

        }
    }


    public ContactPropertiesClient contactsPropertiesClient() {
        return new ContactPropertiesClient();
    }

    public class ContactPropertiesClient {

        public Get get(String name) throws IOException {
            Get request = new Get(name);
            initialize(request);
            return request;
        }

        public class Get extends HBSPTRequest<ContactPropertyOptionsResponse> {

            private static final String REST_PATH = "/contacts/v2/properties/named/{name}";

            @com.google.api.client.util.Key
            private java.lang.String name;

            protected Get(String name) {
                super(HBSPTClient.this, "GET", REST_PATH, null, ContactPropertyOptionsResponse.class);
                this.name = ((String) Preconditions.checkNotNull(name, "Required parameter 'name' for the property must be specified."));
            }

        }

    }

    public DealsClient dealsClient() {
        return new DealsClient();
    }

    public class DealsClient {

        public Update update(String dealId, farm.shangrila.hubspot.api.model.DealsUpdate content) throws java.io.IOException {
            Update result = new Update(dealId, content);
            initialize(result);
            return result;
        }

        public class Update extends HBSPTRequest<farm.shangrila.hubspot.api.model.DealsResponse> {

            @com.google.api.client.util.Key
            private java.lang.String dealId;

            private static final String REST_PATH = "deals/v1/deal/{dealId}";

            protected Update(String dealId, farm.shangrila.hubspot.api.model.DealsUpdate content) {
                super(HBSPTClient.this, "PUT", REST_PATH, content, farm.shangrila.hubspot.api.model.DealsResponse.class);
                this.dealId = ((String) Preconditions.checkNotNull(dealId,
                        "Required parameter contactId must be specified."));
            }

        }

        public Insert insert(farm.shangrila.hubspot.api.model.Deals content) throws java.io.IOException {
            Insert result = new Insert(content);
            initialize(result);
            return result;
        }

        public class Insert extends AbstractGoogleJsonClientRequest<DealsResponse> {

            private static final String REST_PATH = "deals/v1/deal";

            protected Insert(farm.shangrila.hubspot.api.model.Deals content) {
                super(HBSPTClient.this, "POST", REST_PATH, content, farm.shangrila.hubspot.api.model.DealsResponse.class);
            }

        }

        public Get get(String dealId) throws java.io.IOException {
            Get result = new Get(dealId);
            initialize(result);
            return result;
        }

        public class Get extends HBSPTRequest<farm.shangrila.hubspot.api.model.DealsResponse> {

            private static final String REST_PATH = "deals/v1/deal/{dealId}";

            @com.google.api.client.util.Key
            private java.lang.String dealId;

            protected Get(String dealId) {
                super(HBSPTClient.this, "GET", REST_PATH, null, farm.shangrila.hubspot.api.model.DealsResponse.class);
                this.dealId = ((String) Preconditions.checkNotNull(dealId,
                        "Required parameter dealId must be specified."));
            }

        }
    }

    public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {
        public Builder(
                com.google.api.client.http.HttpTransport transport
                , com.google.api.client.json.JsonFactory jsonFactory
                , HBSPTHttpRequestInitializer httpRequestInitializer
        ) {
            super(transport, jsonFactory, DEFAULT_ROOT_URL, DEFAULT_SERVICE_PATH, httpRequestInitializer, false);
        }

        @Override
        public HBSPTClient.Builder setApplicationName(String applicationName) {
            return (Builder) super.setApplicationName(applicationName);
        }

        @Override
        public HBSPTClient build() {
            return new HBSPTClient(this);
        }
    }
}