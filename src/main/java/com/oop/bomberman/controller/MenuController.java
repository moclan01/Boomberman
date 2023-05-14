package com.oop.bomberman.controller;

import com.oop.bomberman.Bomberman;
import com.oop.bomberman.test.ControlViewApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button exitButton;

    @FXML
    private void newGameStage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Bomberman.class.getResource("FXML/app-view.fxml"));
        anchorPane.getChildren().setAll((AnchorPane)fxmlLoader.load());
        anchorPane.setStyle("-fx-background-color: #000000");
    }

    @FXML
    private void openControlStage() throws  IOException{
        Stage stage = new Stage();
        ControlViewApplication controlViewApplication = new ControlViewApplication();
        controlViewApplication.start(stage);
    }

    @FXML
    public void closeBbmStage(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
