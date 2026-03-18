package PDVix.controllers;

import PDVix.DTOs.LoginRequestDTO;
import PDVix.core.AppState;
import PDVix.core.SceneManager;
import PDVix.services.AuthService;
import PDVix.services.NetworkService;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class LoginController {
    private final AuthService authService;
    private final NetworkService networkService;

    public LoginController(
            AuthService authService,
            NetworkService networkService) {
        this.authService = authService;
        this.networkService = networkService;
    }

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private Circle circleLoginStatus;

    @FXML
    public void initialize() {
        statusLabel.textProperty().bind(
                Bindings.when(AppState.onlineProperty())
                        .then("Conectado ao servidor")
                        .otherwise("Modo offline")
        );

        AppState.onlineProperty().addListener(
                (obs, oldVal, newVal) -> {
                    circleLoginStatus.getStyleClass().removeAll("online", "offline");
                    circleLoginStatus.getStyleClass().add(newVal ? "online" : "offline");
        });
    }

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

            showError(ex.getMessage() + ex.getLocalizedMessage() + ex.getCause());

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
