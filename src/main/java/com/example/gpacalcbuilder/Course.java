package com.example.gpacalcbuilder;

public class Course {
    private String courseName;
    private String courseCode;
    private String teacher1;
    private String teacher2;
    private int credit;
    private String grade;

    public Course(String courseName, String courseCode, String teacher1, String teacher2, int credit, String grade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.teacher1 = teacher1;
        this.teacher2 = teacher2;
        this.credit = credit;
        this.grade = grade;

    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTeacher1() {
        return teacher1;
    }

    public void setTeacher1(String teacher1) {
        this.teacher1 = teacher1;
    }

    public String getTeacher2() {
        return teacher2;
    }

    public void setTeacher2(String teacher2) {
        this.teacher2 = teacher2;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
