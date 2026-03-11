package PDVix.controllers;

import PDVix.DTOs.LoginRequestDTO;
import PDVix.services.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @Autowired
    private  AuthService authService;

    @FXML
    private void handleLogin() {
        LoginRequestDTO dados =
                new LoginRequestDTO(loginField.getText(), passwordField.getText(), "electron");

        try {
            boolean success = authService.login(dados);
            if(success) {
                System.out.println("Login realizado com sucesso");
            } else  {
                System.out.println("Erro ao realizar login");
            }
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }
}
