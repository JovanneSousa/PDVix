package PDVix.controllers;

import PDVix.core.AppState;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public class PdvController {
    @FXML
    private Circle circleLoginStatus;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        statusLabel.textProperty().bind(
                Bindings.when(AppState.onlineProperty())
                        .then("Online")
                        .otherwise("Offline")
        );

        AppState.onlineProperty().addListener(
                (obs, oldVal, newVal) -> {
            circleLoginStatus.getStyleClass().removeAll("online", "offline");
            circleLoginStatus.getStyleClass().add(newVal ? "online" : "offline");
        });
    }
}
