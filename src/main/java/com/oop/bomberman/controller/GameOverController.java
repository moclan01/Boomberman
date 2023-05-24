package com.oop.bomberman.controller;

import com.oop.bomberman.Bomberman;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button menuButton;

    @FXML
    private Button exitButton;

    @FXML
    public void MenuStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Bomberman.class.getResource("FXML/menu-view.fxml"));
        anchorPane.getChildren().setAll((AnchorPane)fxmlLoader.load());
    }
    @FXML
    public void ExitGame() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
