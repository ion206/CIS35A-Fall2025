/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 3rd, 2025
Date Submitted: December 3rd, 2025


StudentGradingException.java
Student Grading Exception Class (extending Exception)
Part of exception Package

Custom Exception Handler class to centralize capture of all Assignment 6 Exceptions, and to log and fix them.


instance vars:
- int errorNo: The error code to log the excpetion as
- String errorMessage: The Message of the error to log

Main Functions:
+ StudentGradingException(int, String): Overloaded Contructor to build the expcetion and give it the proper classifications
+ logException(): Adds exception info as a newline into an exception logfile
+ fixMissingFile(): Attempts a filename fix by trying a default file name that should work
*/

package exception; //part of exception package

//importing file, date, and excpetion packages
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


//Make Custom Exception by extending original Exception class
public class StudentGradingException extends Exception {
    private int errorNo; //Error Code to log (Type of error)
    private String errorMessage;


    //Overloaded Constructor
    public StudentGradingException(int errorNo, String errorMessage) {
        super(errorMessage);
        this.errorNo = errorNo;
        this.errorMessage = errorMessage;
    }

    public StudentGradingException(){
        super();
        //Defualt Constructor
    }

    // Requirement: Logs exceptions in a text file
    // FLAG - TODO, doublecheck file writing logic and make sure it is in compliance with CIS 35a
    //can we use somthingin FileIO?
    // adds a new line to the excpetion log with the timestamp and error description
    public void logException() {
        String logFile = "exception_log.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write("Timestamp: " + new Date().toString());
            writer.write(" | Error " + errorNo + ": " + errorMessage);
            writer.newLine();
            System.out.println("Exception logged to " + logFile);
        } catch (IOException e) {
            System.out.println("Could not write to log file.");
        }
    }

    // Requirement: Fix at least one exception
    // This method returns a "fixed" filename if the file was missing
    public String fixMissingFile() {
        System.out.println("Attempting to fix missing file error...");
        // In a real app, might be a good idea to prompt the user - Here we return the default so it works
        return "StudentData.txt";
    }

    //Getters
    public int getErrorNo() {
        return errorNo;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}