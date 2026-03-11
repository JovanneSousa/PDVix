package PDVix.http;

import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientProvider {
    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    private HttpClientProvider() {}

    public static HttpClient getClient() {
        return CLIENT;
    }
}
