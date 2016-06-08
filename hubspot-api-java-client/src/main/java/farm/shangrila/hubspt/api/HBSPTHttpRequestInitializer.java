package farm.shangrila.hubspt.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Preconditions;

public class HBSPTHttpRequestInitializer implements HttpRequestInitializer, HttpExecuteInterceptor {

	Logger LOGGER = Logger.getLogger(HBSPTHttpRequestInitializer.class.getSimpleName());
	private final Map<String, Object> params = new HashMap<String, Object>();
	private JsonFactory jsonFactory;
	private String contentType;

	public HBSPTHttpRequestInitializer(Map<String, Object> params, JsonFactory jsonFactory) {
		Preconditions.checkNotNull(params);
		Preconditions.checkState(params.size() > 0);
		this.params.putAll(params);
		this.jsonFactory = jsonFactory;
	}

	public HBSPTHttpRequestInitializer withJsonContentType()
	{
		this.contentType = "application/json; charset=UTF-8";
		return this;
	}

	public HBSPTHttpRequestInitializer(String name, String value, JsonFactory jsonFactory) {
		Preconditions.checkNotNull(name);
		Preconditions.checkNotNull(value);
		this.params.put(name, value);
		this.jsonFactory = jsonFactory;
	}

	public void initialize(HttpRequest request) throws IOException {
		request.setInterceptor(this);
		request.setUnsuccessfulResponseHandler(new HBSPTUnsuccessfulResponseHandler(jsonFactory));
	}

	public void intercept(HttpRequest request) throws IOException {
		request.getUrl().putAll(params);
		if (this.contentType != null && request.getHeaders().getContentType() == null) {
			LOGGER.info("Content type: " + request.getHeaders().getContentType());
//			request.getHeaders().setContentType(contentType);
			LOGGER.info("Content type: " + request.getHeaders().getContentType());
		}
	}
}