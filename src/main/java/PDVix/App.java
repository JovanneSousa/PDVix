package PDVix;

import PDVix.core.AppContext;
import PDVix.core.SceneManager;
import PDVix.utils.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void init() {
        AppContext.getInstance();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(
                getClass().getResourceAsStream("/fonts/JetBrainsMono-Bold.ttf"), 14
        );
        SceneManager.setStage(stage);

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/views/auth.fxml")
        );

        loader.setControllerFactory(AppContext.getInstance()::getController);

        Scene scene = new Scene(loader.load());

        stage.setTitle("PDVix");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        HibernateUtil.shutdown();
    }

    public static void main(String[] args) {
        launch();
    }
}