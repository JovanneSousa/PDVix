package PDVix.services;

import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkService {
    public boolean isOnline(String serverUrl) {
        try {
            URL url = new URL(serverUrl + "/login");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(2000);
            conn.setRequestMethod("GET");

            int code = conn.getResponseCode();

            return code == 200;
        } catch (Exception e) {
            return false;
        }
    }

}
