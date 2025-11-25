package com.example.gpacalcbuilder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class HomeController {
    @FXML
    public Button startButton;
    public void handleStartButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("course.fxml")));

        Scene scene = new Scene(root);
        Stage stage = (Stage) (startButton) .getScene().getWindow();
        stage.setTitle("GPA Calculator");
        stage.setScene(scene);
        stage.show();
    }
}
