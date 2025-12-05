/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 4th, 2025
Date Submitted: December 4th, 2025


StudentAPIImpl.java
Student API Implemetation Class
Part of adapter packages

Class to implement functions outlined in StudentAPI used to interact with Stats and Students

Overriden Main Functions:
+ void printStatistics: Prints a List of Statistics Calculated between a list of all stored Student Object
+ void printScore: Prints the Score of a specific Student with the given SID

+ StudentAPIImpl() - Default constructor that reads with FileIO and populates Student[] and stats

Instance Vars:
- Student[] students - List of Student Objects to search in and run stats on
- Statistic stats - stats objects to gain access to statistics calculating functions

*/

package adapter;

import model.*;
import util.FileIO;
import exception.StudentGradingException;

public class StudentAPIImpl implements StudentAPI {
    private Student[] students;
    private Statistics stats;

    // Defualt Constructor loads the data to be ready for API calls
    public StudentAPIImpl() {
        this.students = new Student[40]; // Assumption of max students
        this.stats = new Statistics();
        FileIO fileIO = new FileIO();
        
        try {
            // Loading data normally
            fileIO.readFile("StudentData.txt", students);
            
            // Calculate stats immediately
            stats.findlow(students);
            stats.findhigh(students);
            stats.findavg(students);
            
        } catch (StudentGradingException e) {   //Use the Req1 Exception Logging Logic
            System.out.println("API Initialization Error: " + e.getMessage());
        }
    }

    //Overriden from StudentAPI
    //Prints a List of Statistics Calculated between a list of all stored Student Object
    public void printStatistics() {
        System.out.println("--- API: Class Statistics ---");
        stats.print(4); // Print All (Low, High, Avg)
    }

    //Overriden from StudentAPI
    //Prints the Score of a specific Student with the given SID
    public void printScore(int studentId) {
        System.out.println("--- API: Score Search for ID " + studentId + " ---");
        boolean found = false;
        for(Student s : students) {
            if(s != null && s.getSID() == studentId) {
                s.print();
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
}