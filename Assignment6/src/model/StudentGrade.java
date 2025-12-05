/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 4th, 2025
Date Submitted: December 4th, 2025


StudentGrade.java
Generates Student Grade Report
Part of model Package


Main Functions:
+ void printGradeReport(): Prints the Student Grade Report along with class stats

*/

package model;

import java.io.Serializable;


//Container class for Serialization
public class StudentGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Student student;
    private Statistics statistics;

    //Default Constructor
    public StudentGrade(Student student, Statistics statistics) {
        this.student = student;
        this.statistics = statistics;
    }


    //Getters
    public Student getStudent() {
        return student;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    //Prints the Student Grade Report along with class stats
    public void printGradeReport() {
        System.out.println("--- Student Grade Report ---");
        student.print();
        System.out.println("\n--- Class Statistics ---");
        statistics.print(4); // Print all stats
    }
}