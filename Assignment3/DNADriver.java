/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 3 - OOP
Due Date: November 2nd, 2025
Date Submitted: November 2nd, 2025


DNADriver.java - DNA Driver Class
Driver class to test the functionality of the DNA class 

Gets DNA Strand sequence from the user, uses it to create a new DNA sequence object
then, calls print on it, gets the highest molarMass and the totalDensity of the strand 
and print them to the user

Functions
Has default contructor and print function (empty becuase there are no instance variables)

main:
Gets a DNA stand string from the user and creates a DNA object using it. Then calls print, highestsMolarMass and totalDensity on it
*/

import java.util.Scanner;

public class DNADriver {

    /*
     Main Method (Driver) to demonstrate DNA class
     gets DNA strand string from user and calls overloaded constructor on DNA class using it
     Then prints the class, its highest molar mass, and its totalDensity

     scan (Scanner ) - Input Scanner Object
     dnaHelix (DNA) - instance of the DNA class that is being used, populated and printed
     */
    public static void main(String[] args) {
        //Get DNA Strand from user input
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter DNA Strand: ");
        String strand = scan.nextLine();
        System.out.println("Using Input Strand: " + strand);

        //Create DNA object using overloaded contructor
        DNA dnaHelix = new DNA(strand);

        //Test print() method
        dnaHelix.print();

        //Test highestMolarMass() method
        dnaHelix.highestMolarMass();

        //Test totalDensity() method
        dnaHelix.totalDensity();
    }

    //Default Contructor
    public DNADriver(){
        //empty becuase no instance vars
    }

    //Print Function
    public void print(){
        //empty becuase no instance vars
    }
}
