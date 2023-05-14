package com.oop.bomberman.test;

import com.oop.bomberman.Bomberman;
import com.oop.bomberman.controller.PlayerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BombermanTest extends Application {
    private static Scene scene;

    public static Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Bomberman.class.getResource("FXML/app-view.fxml"));
        AnchorPane root = fxmlLoader.load();

        scene = new Scene(root);
        PlayerController control = new PlayerController();
        control.handle(scene);

        stage.setTitle("Bomberman");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}