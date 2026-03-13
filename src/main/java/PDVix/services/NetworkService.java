package PDVix.services;

import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkService {
    public boolean isOnline(String serverUrl) {
        try {
            URL url = new URL(serverUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(2000);
            conn.setRequestMethod("GET");

            int code = conn.getResponseCode();

            return code >= 200 && code <= 500;
        } catch (Exception e) {
            return false;
        }
    }

}
