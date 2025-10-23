/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 2
Due Date: October 26th, 2025
Date Submitted: October 26th, 2025
*/

import java.util.Scanner;
/*
 * 
 * Assignment 2 Part 1 - Human Genome OOP
 * 
 * Genome Input Class
 * 
Design:
 * Serves as the input/Driver class and creates HumanGenome objects using user inputted data
 * 
 * 
 * Functions
 * Has default contructor and print function (empty becuase there are no instance variables)
 * 
 * input(scanner(Scanner)):
 * Contains the instance method for inputting HumanGenome data using Scanner
 * and the main driver method to demonstrate the HumanGenome class
 * 
 * main:
 * calls input creating three unique Human Genome Objects, stores their refs and calls print on them
 */
public class GenomeInput {

    /**
     * Instance method that uses Scanner to prompt the user for data then creates a new HumanGenome object, and returns it
     * scanner (Scanner) The Scanner object used for input
     * Returns a fully initialized HumanGenome instance
     */
    public HumanGenome input(Scanner scanner) {
        
        // --- 1. Genome Name (String) ---
        System.out.print("Enter Genome Name (e.g., Mickey Mouse): ");
        String name = scanner.nextLine();
        
        // --- 2. Number of Genes (int) ---
        System.out.print("Enter Number of Genes (e.g., 20000): ");
        int genes = Integer.parseInt(scanner.nextLine()); 
        
        // --- 3. Number of Chromosomes (int) ---
        System.out.print("Enter Number of Chromosomes (e.g., 46): ");
        int chromosomes = Integer.parseInt(scanner.nextLine());
        
        // --- 4. Number of Cells in Trillions (double) ---
        System.out.print("Enter Number of Cells in Trillions (e.g., 76.0 or 75.5): ");
        double cellsTrillions = Double.parseDouble(scanner.nextLine());
        
        System.out.printf("\n\n");
        
        // Create and return the instance
        return new HumanGenome(name, genes, chromosomes, cellsTrillions);
    }

    /**
     * Main method (Driver) that demonstrates the HumanGenome class
     * Creates three instances by calling the input() method and then prints them
     * scanner (Scanner) - Input Scanner
     * genome1,2,3 are all instances of the HumanGenome Class
     */
    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create an instance of GenomeInput to call the input() method
        GenomeInput genomeManager = new GenomeInput();

        //Disney Characters for storing the Genomes
        HumanGenome genome1 = genomeManager.input(scanner);

        HumanGenome genome2 = genomeManager.input(scanner);

        HumanGenome genome3 = genomeManager.input(scanner);

        // Close the scanner after all input is finished
        scanner.close();

        System.out.println("\n\n*** Printing the 3 Human Genome Objects ***");
        
        // Print the print function of each created instance
        genome1.print();
        genome2.print();
        genome3.print();
    }


    //Default Contructor
    public GenomeInput(){
        //empty becuase no instance vars
    }

    //Print Function
    public void print(){
        //empty becuase no instance vars
    }
}
