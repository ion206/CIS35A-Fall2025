/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 2
Due Date: October 28th, 2025
Date Submitted: October 28th, 2025

GenoNucleicAcid.java
Driver program to demonstrate the NucleicAcid class. It uses the input method and Scanner to create three NucleicAcid instances and prints them all out

Functions:
Default Contructor
print() function
input(scanner (Scanner)) - gets input from user and creates a new NucleicAcid Object then returns it
main - calls input and saves refs for 3 Nucleic Acid objects then calls print on them
*/

import java.util.Scanner;

public class GenoNucleicAcid {

    /*
     * Instance method that uses Scanner to prompt the user for data, creates a new NucleicAcid object, and returns it
     * scanner (Scanner) - The Scanner object used for input
     * returns a fully initialized NucleicAcid instance
     */
    public NucleicAcid input(Scanner scanner) {
        // Name (String) 
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        //Chemical Formula (String) 
        System.out.print("Enter Chemical Formula: ");
        String formula = scanner.nextLine();
        
        //Molar Mass (float) 
        System.out.print("Enter Molar Mass (g/mol): ");
        float molarMass = Float.parseFloat(scanner.nextLine());
        
        //Density (float) 
        System.out.print("Enter Density (g/cm3): ");
        float density = Float.parseFloat(scanner.nextLine());

        System.out.printf("\n\n"); //Create two lines of space between input lines and whats next
        
        // Create and return the instance
        return new NucleicAcid(name, formula, molarMass, density);
    }


    /**
     * Driver method (main) that demonstrates the NucleicAcid class 
     * by calling the input() method three times to create three instances of the claass then prints them
     */
    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create an instance of GenoNucleicAcid to call the instance method input()
        GenoNucleicAcid acidManager = new GenoNucleicAcid();

        //Instance 1 
        NucleicAcid acid1 = acidManager.input(scanner);

        //Instance 2 
        NucleicAcid acid2 = acidManager.input(scanner);

        //Instance 3 
        NucleicAcid acid3 = acidManager.input(scanner);

        // Close the scanner after all input is finished
        scanner.close();
        
        // Print the details of each created instance
        acid1.print();
        acid2.print();
        acid3.print();
        
    }

    //Default Constructor
    public GenoNucleicAcid(){
        //No instance variables to set
    }

    //Print Function
    public void print(){
        //No instance or class variables to print
    }
}
