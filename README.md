#Haque_2207081_GPACalculatorBuilder

A simple JavaFx Application to calculate GPA 

##Overview

This project is a lightweight JavaFX application designed to help students quickly calculate their Grade Point Average (GPA).
It provides an intuitive interface where users can enter course names, course code, credits, course teachers name and grades, and instantly receive the calculated GPA.

## Features

Add multiple courses dynamically
Input course name, course code, credits, course teachers name and grade
When the sum of entered credits matches the total credit the Calculate GPA button gets activated
Simple, clean JavaFX UI
Real-time recalculation when entries change

## Project Structure

Haque_2207081_GPACalculatorBuilder
│
├── .idea/
│   ├── .gitignore
│   ├── encodings.xml
│   ├── misc.xml
│   └── vcs.xml
│
├── .mvn/
│   └── wrapper/
│       ├── maven-wrapper.jar
│       └── maven-wrapper.properties
│
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .gitignore
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/gpacalcbuilder/
│       │        ├── Course.java
│       │        ├── CourseController.java
│       │        ├── HomeController.java
│       │        ├── Main.java
│       │        ├── ResultController.java
│       │        └── module-info.java
│       │
│       └── resources/
│           └── com/example/gpacalcbuilder/
│                ├── course.fxml
│                ├── home.fxml
│                └── result.fxml
