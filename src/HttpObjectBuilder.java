import java.util.HashMap;
import java.util.Map;

public class HttpObjectBuilder implements HttpRequestBuilder {
    private String url;
    private String method;
    private final Map<String, String> headers = new HashMap<>();
    private String body;

    @Override
    public HttpObjectBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public HttpObjectBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public HttpObjectBuilder addHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    @Override
    public HttpObjectBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public HttpRequest getResult() {
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("Validation error: URL cannot be null or blank");
        }
        if (method == null || method.isBlank()) {
            throw new IllegalStateException("Validation error: HTTP Method must be defined");
        }
        return new HttpRequest(url, method, headers, body);
    }
}