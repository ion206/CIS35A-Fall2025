/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 3rd, 2025
Date Submitted: December 3rd, 2025


StudentAPI.java
Student API Decleration Class
Part of adapter packages

Class to Declare functions used to interact with Stats and Students, to be later implemneted. "Menu" of available Functions

Functions are implemented in StudentAPIImpl.java

Main Functions:
+ void printStatistics: Prints a List of Statistics Calculated between a list of all stored Student Object
+ void printScore: Prints the Score of a specific Student with the given SID

*/
package adapter;

public interface StudentAPI {
    // Print student statistics blueprint
    public void printStatistics();
    
    // Print score for a given student id blueprint
    public void printScore(int studentId);
}