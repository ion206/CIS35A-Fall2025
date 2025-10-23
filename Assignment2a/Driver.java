
/**
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 2A
Due: Oct 19th 2025
Submitted: Oct 19th 2025



 * Driver.java
 *
 * This class demonstrates the Person class by creating three instances,
 * populating their data from user input using a Scanner in readValue(), and calling print on them.
 * 
 * Design:
 * 
 * Variables:
 * scan (Scanner) - scanner object for getting the input from the user
 * Stacey (Person) - Holds an Person class instance depending on what the user inputs
 * Ross (Person) - Like Stacey, Holds an Person class instance depending on what the user inputs
 * Mia (Person) - Like Stacey, Holds an Person class instance depending on what the user inputs
 * 
 * Methods:
 * readValue() -> Person - function part of Driver that inputs info from the user about a person and creates a class populated with that info
 * 
 * Driver () - required default contructor - no instance vars so empty
 * print() - prints instance vars - there are none so its also empty
 */

import java.util.Scanner;

public class Driver {

    // Declare Scanner object
    // making it static so it works and applies for all instances of the Driver class 
    static Scanner scan = new Scanner(System.in);

    public Driver() {
        //Default Constructor
        // no instance vars need updating so leaving this blank
    }

    public static void main(String[] args) {
        Driver d1 = new Driver();

        // Object 1: Stacey
        System.out.println("--- Entering Data for Stacey ---");
        Person Stacey = d1.readValue();
        Stacey.print();

        // Object 2: Ross
        System.out.println("--- Entering Data for Ross ---");
        Person Ross = d1.readValue();
        Ross.print();

        // Object 3: Mia
        System.out.println("--- Entering Data for Mia ---");
        Person Mia = d1.readValue();
        Mia.print();

        // Close the scanner when finished
        scan.close();
    }

    /**
     * Prompts the user to enter data for a Person object, reads the input
     * using the Scanner, creates a Person object, and returns it.
     *  
     * String name, address and phoneNumber along with int age are all temp vars for holding what the user inputs
     * returns (Person) A newly created Person object populated with user input.
     */
    public Person readValue() {
        System.out.print("Enter Name (e.g., Student A): ");
        String name = scan.nextLine();

        System.out.print("Enter Address (e.g., 123 Main St): ");
        String address = scan.nextLine();

        System.out.print("Enter Age (must be an integer): ");
        // Read as String and parse immediately. If the input is invalid,
        // a NumberFormatException will stop the program.
        String ageString = scan.nextLine(); //nextLine gives a string and we want to save it as an int so we have to parse
        int age = Integer.parseInt(ageString);

        System.out.print("Enter Phone Number (e.g., 555-123-4567): ");
        String phoneNumber = scan.nextLine();

        // Create and return the Person object using the overloaded constructor
        return new Person(name, address, age, phoneNumber);
    }

    public void print() {
        //Print all instance variables of driver
        // No instance variables so nothing to print
    }
}
