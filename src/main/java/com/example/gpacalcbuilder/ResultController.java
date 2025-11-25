package com.example.gpacalcbuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.util.List;

public class ResultController {

    @FXML private Label gpaLabel;
    @FXML private Label creditLabel;
    @FXML private TableView<Course> resultTable;
    @FXML private TableColumn<Course, String> courseNameColumn;
    @FXML private TableColumn<Course, String> courseCodeColumn;
    @FXML private TableColumn<Course, String> teacher1Column;
    @FXML private TableColumn<Course, String> teacher2Column;
    @FXML private TableColumn<Course, Integer> creditColumn;
    @FXML private TableColumn<Course, String> gradeColumn;

    private List<Course> courses;

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        displayResults();
    }

    @FXML
    private void initialize() {


        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        courseCodeColumn.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        teacher1Column.setCellValueFactory(new PropertyValueFactory<>("teacher1"));
        teacher2Column.setCellValueFactory(new PropertyValueFactory<>("teacher2"));
        creditColumn.setCellValueFactory(new PropertyValueFactory<>("credit"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));


    }

    private void displayResults() {
        if (courses == null || courses.isEmpty()) {
            gpaLabel.setText("Overall GPA: 0.00");
            creditLabel.setText("Total Credits: 0");
            return;
        }

        double totalPoints = 0;
        int totalCredits = 0;

        for (Course course : courses) {
            double gradePoint = convertGradeToPoint(course.getGrade());
            totalPoints += gradePoint * course.getCredit();
            totalCredits += course.getCredit();
        }

        double gpa = totalCredits > 0 ? totalPoints / totalCredits : 0.0;

        gpaLabel.setText(String.format("Overall GPA: %.2f", gpa));
        creditLabel.setText(String.format("Total Credits: %d", totalCredits));

        ObservableList<Course> tableData = FXCollections.observableArrayList(courses);
        resultTable.setItems(tableData);

    }

    private double convertGradeToPoint(String grade) {
        if (grade == null) return 0.0;

        switch (grade) {
            case "A+": return 4.00;
            case "A": return 3.75;
            case "A-": return 3.50;
            case "B+": return 3.25;
            case "B": return 3.00;
            case "B-": return 2.75;
            case "C+": return 2.50;
            case "C": return 2.25;
            case "D": return 2.00;
            case "F": return 0.00;
            default: return 0.0;
        }
    }

}