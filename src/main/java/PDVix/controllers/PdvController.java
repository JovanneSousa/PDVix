package PDVix.controllers;

import PDVix.App;
import PDVix.core.AppState;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

public class PdvController {
    @FXML
    private Circle circleLoginStatus;

    @FXML
    private Label statusLabel;

    @FXML
    private Button search;

    @FXML
    public void initialize() {
        statusLabel.textProperty().bind(
                Bindings.when(AppState.onlineProperty())
                        .then("Online")
                        .otherwise("Offline")
        );

        updateClassStatus(AppState.onlineProperty().get());
        setIcons();

        AppState.onlineProperty().addListener(
                (obs, oldVal, newVal) -> updateClassStatus(newVal));
    }

    void updateClassStatus(boolean isOnline) {
        circleLoginStatus.getStyleClass().removeAll("online", "offline");
        circleLoginStatus.getStyleClass().add(isOnline ? "online" : "offline");
    }

    void setIcons() {
        FontIcon lupaIcon =
                new FontIcon(FontAwesomeSolid.SEARCH);
        lupaIcon.getStyleClass().add("searchIcon");
        lupaIcon.setIconSize(20);

        search.setGraphic(lupaIcon);
        search.setText("");
    }
}
