module com.oop.bomberman {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.oop.bomberman to javafx.fxml;
    exports com.oop.bomberman;
    exports com.oop.bomberman.model;
    opens com.oop.bomberman.model to javafx.fxml;
    exports com.oop.bomberman.controller;
    opens com.oop.bomberman.controller to javafx.fxml;
}