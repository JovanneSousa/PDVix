package PDVix.controllers;

import PDVix.DTOs.LoginRequestDTO;
import PDVix.core.SceneManager;
import PDVix.services.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

        try {

            LoginRequestDTO dados =
                    new LoginRequestDTO(
                            loginField.getText(),
                            passwordField.getText(),
                            "electron"
                    );

            boolean success = authService.login(dados);

            if(success){

                System.out.println("Login realizado com sucesso");

                SceneManager.switchScene("pdv.fxml");

            } else {

                showError("Usuário ou senha inválidos");

            }

        } catch (Exception ex) {

            showError(ex.getMessage());

        }
    }

    private void showError(String message){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }
}
