package com.oop.bomberman.controller;

import com.oop.bomberman.Bomberman;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button exitButton;

    @FXML
    public void ExitGame() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void startGameOver() {
        FXMLLoader fxmlLoader = new FXMLLoader(Bomberman.class.getResource("FXML/gameover-view.fxml"));
        AnchorPane root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        PlayerController control = new PlayerController();
        control.handle(scene);

        stage.setTitle("Bomberman");
        stage.setScene(scene);
        stage.show();
    }
}
