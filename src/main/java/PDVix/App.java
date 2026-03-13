package PDVix;

import PDVix.core.SceneManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;


/**
 * JavaFX App
 */
@SpringBootApplication
public class App extends Application {

    private static ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = SpringApplication.run(App.class);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(
                getClass().getResourceAsStream("/fonts/JetBrainsMono-Bold.ttf"), 14
        );
        SceneManager.setStage(stage);
        SceneManager.setContext(context);

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/views/auth.fxml")
        );

        loader.setControllerFactory(context::getBean);

        Scene scene = new Scene(loader.load());

        stage.setTitle("PDVix");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
    }

    public static void main(String[] args) {
        launch();
    }
}