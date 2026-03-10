package PDVix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(
                getClass().getResourceAsStream("/fonts/JetBrainsMono-Bold.ttf"), 14
        );

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/views/main.fxml")
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("PDVix");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}