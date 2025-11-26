package model;

import java.io.Serializable;

// Req 2: Container class for Serialization
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