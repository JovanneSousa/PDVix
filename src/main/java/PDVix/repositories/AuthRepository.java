package PDVix.repositories;

import PDVix.DTOs.LoginRequestDTO;
import PDVix.DTOs.LoginResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
public class AuthRepository {
    ObjectMapper mapper = new ObjectMapper();
    public boolean login(LoginRequestDTO dto, HttpRequest request) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            LoginResponseDTO reposta = mapper.readValue(response.body(), LoginResponseDTO.class);
            System.out.println(reposta.toString());
            return response.statusCode() == 200;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
