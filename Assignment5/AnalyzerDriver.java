/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 5
Due Date: November 24th, 2025
Date Submitted: November 24th, 2025


AnalyzerDriver.java
ScoreAnalyzer Driver Class
holds the public static main entry point and orchestrates the program flow: 
reads data using Util, computes statistics, and prints the final tables

constants:
FILE_NAME - holds the name of the file that data must be read from
MAX_STUDENTS - size the Student[] is set to, this is the max number of Students that can be proccessed
*/

public class AnalyzerDriver {
    //Constants
    private static final String FILE_NAME = "data.txt";
    private static final int MAX_STUDENTS = 40;

    // Prints the formatted header for the student data table.
    public static void printDataHeader() {
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-7s%-7s%-7s%-7s%-7s%-7s\n", "Stud", "Q1", "Q2", "Q3", "Q4", "Q5");
        System.out.println("-------------------------------------------------------");
    }

     //Prints the entire populated student data table.
     //Student[] students -  The array of Student objects.
    public static void printStudentData(Student[] studentData) {
        System.out.println("\n--- Student Quiz Scores (Input Order) ---");
        printDataHeader();
        
        for(int i = 0; i < studentData.length; i++){
            Student student = studentData[i];
            if (student != null && student.getSID() != 0) {
                student.print();
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Instantiate the Student array with max capacity
        Student[] students = new Student[MAX_STUDENTS];
        
        // Instantiate Util class
        Util fileUtility = new Util();
        
        // Populate the student array
        // The array is passed by reference and then returned (as per sample usage)
        System.out.println("Reading data from: " + FILE_NAME);
        students = fileUtility.readFile(FILE_NAME, students);
        
        // Check if parsing was successful
        if (students.length == 0 || students[0] == null) {
            System.out.println("File reading error!");
            return; //exit the program
        }

        // Print the data table
        printStudentData(students);
        
        // Instantiate Statistics class
        Statistics quizStats = new Statistics();
        
        // Compute statistics
        quizStats.findlow(students);
        quizStats.findhigh(students);
        quizStats.findavg(students); 

        // Print Statistics
        System.out.println("\n--- Statistical Analysis per Quiz ---");
        printDataHeader();
        
        // Print all statistics (option 4 of the print function)
        quizStats.print(4);
        System.out.println("-------------------------------------------------------");
    }
}