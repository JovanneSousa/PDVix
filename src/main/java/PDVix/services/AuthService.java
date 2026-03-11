package PDVix.services;

import PDVix.DTOs.LoginRequestDTO;
import PDVix.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
public class AuthService {
    @Autowired
    private AuthRepository repository;

    public boolean login(LoginRequestDTO dto){

        String body = "login=" + dto.getLogin() +
                "&password=" + dto.getPassword() +
                "&uuid_v4=electron";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost/auth"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();


        return repository.login(dto, request);
    }
}
