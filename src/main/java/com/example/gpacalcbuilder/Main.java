package com.example.gpacalcbuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));

        Scene scene = new Scene(root);
        stage.setTitle("GPA Calculator");
        stage.setScene(scene);
        stage.show();
    }




}
