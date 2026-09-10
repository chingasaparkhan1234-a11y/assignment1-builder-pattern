public class CurlCommandBuilder implements HttpRequestBuilder {
    private String url = "";
    private String method = "GET";
    private final StringBuilder headersPart = new StringBuilder();
    private String bodyPart = "";

    @Override
    public CurlCommandBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public CurlCommandBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public CurlCommandBuilder addHeader(String key, String value) {
        headersPart.append(" -H '").append(key).append(": ").append(value).append("'");
        return this;
    }

    @Override
    public CurlCommandBuilder setBody(String body) {
        if (body != null && !body.isBlank()) {
            this.bodyPart = " -d '" + body + "'";
        }
        return this;
    }

    public String getResult() {
        if (url.isBlank()) {
            throw new IllegalStateException("Validation error: URL is required for cURL command");
        }
        return "curl -X " + method + " '" + url + "'" + headersPart.toString() + bodyPart;
    }
}