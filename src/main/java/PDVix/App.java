package PDVix;

import PDVix.controllers.LoginController;
import PDVix.core.AppContext;
import PDVix.core.SceneManager;
import PDVix.utils.HibernateUtil;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        AppContext.getInstance();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), e -> {
                    AppContext
                            .getInstance()
                            .getNetworkService()
                            .checkConnection();
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

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