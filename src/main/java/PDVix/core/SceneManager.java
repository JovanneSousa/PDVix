package PDVix.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Setter;

public class SceneManager {
    @Setter
    private static Stage stage;

    public static void switchScene(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource("/views/"+ fxml)
        );
        loader.setControllerFactory(AppContext.getInstance()::getController);
        Scene scene = new Scene(loader.load());

        stage.setScene(scene);
        stage.show();
    }
}
