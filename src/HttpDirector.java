public class HttpDirector {

    public void makeAuthPostRequest(HttpRequestBuilder builder) {
        builder.setUrl("https://api.example.com/v1/auth/login")
                .setMethod("POST")
                .addHeader("Content-Type", "application/json")
                .setBody("{\"username\": \"admin\", \"password\": \"secret123\"}");
    }

    public void makeGetUserRequest(HttpRequestBuilder builder) {
        builder.setUrl("https://api.example.com/v1/users/42")
                .setMethod("GET")
                .addHeader("Accept", "application/json");
    }
}