package PDVix.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Setter;
import org.springframework.context.ApplicationContext;

public class SceneManager {
    @Setter
    private static Stage stage;
    @Setter
    private static ApplicationContext context;

    public static void switchScene(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource("/views/"+ fxml)
        );
        loader.setControllerFactory(context::getBean);
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();
    }
}
