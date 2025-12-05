/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 4th, 2025
Date Submitted: December 4th, 2025


Driver2.java
Req2 Driver Class
Part of driver Package

Driver Class to demonstrate Serializing Files

Main Functions:
+ static void main(String[]): Creates simulated Student, seralizing stats and grade data, then unseralizes and prints
+ Driver2(): Default Constructor

*/

package driver;

import util.FileIO;
import model.*;

public class Driver2 {
    public static void main(String[] args) {
        System.out.println("--- Driver 2: Serialization ---");

        //Create new Student and Setup data
        Student student = new Student();
        student.setSID(1234);
        int[] scores = {90, 85, 88, 92, 95};
        student.setScores(scores);

        Statistics stats = new Statistics();
        // (Empty stats for demo, or you can populate them)

        // Create the Grade object
        StudentGrade grade = new StudentGrade(student, stats);
        
        // Serialize
        FileIO io = new FileIO();
        String filename = "student_grade.ser";
        //Call File IO Serialize Function
        io.serializeStudentGrade(grade, filename);
        
        // Deserialize to prove it worked
        System.out.println("\nReading back serialized object...");
        StudentGrade loadedGrade = io.deserializeStudentGrade(filename);
        
        if (loadedGrade != null) {
            System.out.println("Deserialized successfully:");
            loadedGrade.getStudent().print();
        }
    }

    public Driver2(){
        //Default Constructor
    }
}