package farm.shangrila.hubspt.api;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.json.JsonFactory;

import java.io.IOException;
import java.util.logging.Logger;

public class HBSPTUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {

    private static final Logger log = Logger.getLogger(HBSPTUnsuccessfulResponseHandler.class.getName());

    private JsonFactory jsonFactory;

    public HBSPTUnsuccessfulResponseHandler(JsonFactory jsonFactory) {
        // TODO Auto-generated constructor stub
        this.jsonFactory = jsonFactory;
    }

    public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry)
            throws IOException {

        String responseAsString = response.parseAsString();
        log.warning(request.getRequestMethod() + ": " + request.getUrl() + " generate HBSPTResponseException: " + responseAsString);

        HBSPTJsonErrorResponse hbsptJsonErrorReponse = null;

        try {
            hbsptJsonErrorReponse = jsonFactory.fromString(responseAsString, HBSPTJsonErrorResponse.class);
        } catch (IOException e) {
            String errorMessage = "IOException during parse of HBSPTJsonErrorResponse: " + e.getMessage();
            log.severe(errorMessage);

            // fill with base infos
            hbsptJsonErrorReponse = new HBSPTJsonErrorResponse();
            hbsptJsonErrorReponse.setMessage(errorMessage);
            hbsptJsonErrorReponse.setStatus(String.valueOf(response.getStatusCode()));
        }

        throw new HBSPTResponseException(responseAsString, hbsptJsonErrorReponse);
    }
}