module PDVix {
    requires javafx.controls;
    requires javafx.fxml;

    opens PDVix.controllers to javafx.fxml;
    exports PDVix;
}
