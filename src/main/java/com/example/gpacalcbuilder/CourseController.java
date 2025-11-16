package com.example.gpacalcbuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class CourseController {

    @FXML private TextField courseNameField;
    @FXML private TextField courseCodeField;
    @FXML private TextField creditField;
    @FXML private TextField teacher1Field;
    @FXML private TextField teacher2Field;
    @FXML private ComboBox<String> gradeComboBox;
    @FXML private Button addCourseButton;
    @FXML private Button calculateGPAButton;

    private final List<Course> allCourses = new ArrayList<>();
    private int requiredTotalCredits = 12;
    private int currentTotalCredits = 0;

    @FXML
    private void initialize() {
        setupGradeComboBox();
        calculateGPAButton.setDisable(true);
        updateCalculateButton();
    }

    private void setupGradeComboBox() {
        gradeComboBox.getItems().clear();
        String[] grades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "D", "F"};
        for (String grade : grades) {
            gradeComboBox.getItems().add(grade);
        }
    }

    @FXML
    private void handleAddCourse() {
        String courseName = courseNameField.getText();
        String courseCode = courseCodeField.getText();
        String creditText = creditField.getText();
        String teacher1 = teacher1Field.getText();
        String teacher2 = teacher2Field.getText();
        String grade = gradeComboBox.getValue();

        if (courseName.isEmpty() || courseCode.isEmpty() || creditText.isEmpty() ||
                teacher1.isEmpty() || grade == null) {
            showAlert("Error", "Please fill all required fields!");
            return;
        }

        try {
            int credit = Integer.parseInt(creditText);
            Course newCourse = new Course(courseName, courseCode, teacher1, teacher2, credit, grade);

            allCourses.add(newCourse);
            currentTotalCredits += credit;

            updateCalculateButton();
            clearInputFields();

        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter valid credit hours!");
        }
    }

    @FXML
    private void handleCalculateGPA() {
        if (allCourses.isEmpty()) {
            showAlert("Error", "No courses added yet!");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
            Parent root = loader.load();

            ResultController resultController = loader.getController();
            resultController.setCourses(new ArrayList<>(allCourses));

            Stage stage = (Stage) calculateGPAButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("GPA Result");
            stage.show();

        } catch (Exception e) {
            showAlert("Error", "Cannot open result screen!");
        }
    }

    private void updateCalculateButton() {
        if (currentTotalCredits >= requiredTotalCredits) {
            calculateGPAButton.setDisable(false);
            calculateGPAButton.setText("Calculate GPA (" + currentTotalCredits + "/" + requiredTotalCredits + " credits)");
            calculateGPAButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");
        } else {
            calculateGPAButton.setDisable(true);
            calculateGPAButton.setText("Calculate GPA (" + currentTotalCredits + "/" + requiredTotalCredits + " credits)");
            calculateGPAButton.setStyle("-fx-background-color: #95a5a6; -fx-text-fill: white;");
        }
    }

    private void clearInputFields() {
        courseNameField.clear();
        courseCodeField.clear();
        creditField.clear();
        teacher1Field.clear();
        teacher2Field.clear();
        gradeComboBox.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}