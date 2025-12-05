/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 4th, 2025
Date Submitted: December 4th, 2025


Driver1.java
Req1 Driver Class
Part of driver Package

Driver Class to demonstrate exception handling

Main Functions:
+ static void main(String[]): TODO
+ Driver1(): Default Constructor

*/

package driver; //Part of driver Package

import util.FileIO;
import model.Student;
import exception.StudentGradingException;

public class Driver1 {
    public static void main(String[] args) {
        System.out.println("--- Driver 1: Exception Handling ---");
        
        FileIO io = new FileIO();
        Student[] students = new Student[40];
        
        // Trigger Exception by giving a wrong filename
        String badFilename = "DoesNotExist.txt";
        
        try { //Should throw an error becuase of bad Filename
            System.out.println("Attempting to read: " + badFilename);
            io.readFile(badFilename, students);
        } catch (StudentGradingException e) {
            // Log the exception
            System.out.println("Caught Exception: " + e.getMessage());
            e.logException(); //Adding Exception into logFile
            
            // Fix the exception
            // Use the fix method to get the correct filename
            String fixedFilename = e.fixMissingFile();
            System.out.println("Retrying with fixed filename: " + fixedFilename);
            
            try {
                // Retry logic
                io.readFile(fixedFilename, students);
                System.out.println("File read successfully after fix!");
                if(students[0] != null) students[0].print(); // Verify data by printing the first line
            } catch (StudentGradingException ex) {
                System.out.println("Fix failed.");
            }
        }
    }

    public Driver1(){
        //Default Contructor
    }
}