package PDVix.repositories;

import PDVix.DTOs.LoginRequestDTO;
import PDVix.DTOs.LoginResponseDTO;
import PDVix.http.HttpClientProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Repository
@AllArgsConstructor
public class AuthRepository {
    private final ObjectMapper mapper = new ObjectMapper();

    private final HttpClient client = HttpClientProvider.getClient();

    public boolean login(LoginRequestDTO dto) {

        try {
            String body = "login=" + dto.getLogin() +
                    "&password=" + dto.getPassword() +
                    "&uuid_v4=electron";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost/auth"))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            LoginResponseDTO resposta = mapper.readValue(response.body(), LoginResponseDTO.class);
            return resposta.getStatus().equals("success");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
}
