package com.example.gpacalcbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {
    @FXML
    public Button startButton;
    public void handleStartButton()
    {
        System.out.println("Button clicked!");
    }
}
