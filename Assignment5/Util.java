/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 5
Due Date: November 17th, 2025
Date Submitted: November 17th, 2025

Util.java
Util Class
Manages File I/O operations, reading Student and quiz data from files
and populating the array of Student objects.

Main Function is readFile(...) that handles IO and populates a given Student[] with data vals from file
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Util {

    /**
     * Reads the student data from a text file, tokenizes the lines,
     * and populates the Student arrays
     * String filename - Name of the input text file
     * Student[] stu - Student array to be populated (must be large enough)
     * return Student[] - Populated Student array based on input file
     */
    public Student[] readFile(String filename, Student[] stu) {
        int studentIndex = 0;

        // Using try-with-resources for automatic closing of I/O streams
        try (FileReader file = new FileReader(filename);
             BufferedReader buff = new BufferedReader(file)) {
             
            // Skip the header line ("Stud Qu1 Qu2 Qu3 Qu4 Qu5")
            buff.readLine(); 

            String line;
            // 2. Read data line by line until EOF
            while ((line = buff.readLine()) != null && studentIndex < stu.length) {
                // Initialize a new Student object for the array slot
                stu[studentIndex] = new Student(); 
                
                // Tokenize the line
                StringTokenizer st = new StringTokenizer(line);
                
                // Process tokens (SID and 5 scores)
                // Read SID (Token 1)
                stu[studentIndex].setSID(Integer.parseInt(st.nextToken()));
                
                // Read 5 Scores (Tokens 2 through 6)
                for (int i = 0; i < 5; i++) {
                    int score = Integer.parseInt(st.nextToken());
                    stu[studentIndex].setScore(i, score);
                }
                studentIndex++;
            }

        }
        catch (IOException e) {
            System.out.println("Error reading file '" + filename + "'. Ensure it exists in the correct directory.");
            System.out.println("Details: " + e.getMessage());
            // Return empty or partially filled array on error
            return new Student[0]; 
        }
        // Return the array reference (now populated)
        return stu; 
    }

    //Default Constructor
    public Util(){
        //empty
    }
}