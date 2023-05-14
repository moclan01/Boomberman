package com.oop.bomberman.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlViewController {
    @FXML
    private Button closeButton;

    @FXML
    private void closeControlStage(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
