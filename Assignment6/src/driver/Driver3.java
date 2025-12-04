/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 3rd, 2025
Date Submitted: December 3rd, 2025


Driver3.java
Req 3 Driver Class
Part of driver Package

Driver Class to demonstrate StudentAPI and its implemenation

Main Functions:
+ static void main(String[]): Creates a StudentAPI Implementation Object then calls function with its API to test functionality
+ Driver3(): Default Constructor
*/

package driver;

import adapter.StudentAPI;
import adapter.StudentAPIImpl;

public class Driver3 {
    public static void main(String[] args) {
        System.out.println("--- Driver 3: Adapter/API Pattern ---");

        // Instantiate the Implementation
        StudentAPI api = new StudentAPIImpl();

        // Use API to print statistics
        api.printStatistics();
        
        System.out.println(); //buffer line

        // Use API to print specific student score (Assuming 1234 exists in your text file)
        api.printScore(1234); 
    }

    public Driver3(){
        //Empty Default Contructor
    }
}