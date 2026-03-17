package PDVix.core;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class AppState {

    private static final BooleanProperty online = new SimpleBooleanProperty(false);

    public static BooleanProperty onlineProperty() {
        return online;
    }

    public static boolean isOnline() {
        return online.get();
    }

    public static void setOnline(boolean value) {
        online.set(value);
    }
}
