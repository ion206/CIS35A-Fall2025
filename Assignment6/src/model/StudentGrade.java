/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 3rd, 2025
Date Submitted: December 3rd, 2025


StudentGrade.java
Generates Student Grade Report
Part of model Package

Driver Class to demonstrate exception handling

Main Functions:
+ static void main(String[]): TODO
+ Driver1(): Default Constructor

*/

package model;

import java.io.Serializable;

//FLAG: TODO, Check Serializable logic and implemtnation based on 35A standards 

//Container class for Serialization
public class StudentGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Student student;
    private Statistics statistics;

    public StudentGrade(Student student, Statistics statistics) {
        this.student = student;
        this.statistics = statistics;
    }

    public Student getStudent() {
        return student;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void printGradeReport() {
        System.out.println("--- Student Grade Report ---");
        student.print();
        System.out.println("\n--- Class Statistics ---");
        statistics.print(4); // Print all stats
    }
}