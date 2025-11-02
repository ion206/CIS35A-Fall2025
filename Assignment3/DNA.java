/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 3 - OOP
Due Date: November 2nd, 2025
Date Submitted: November 2nd, 2025

DNA.java - DNA Class
Implements Containment (arrays of NucleicAcid objects) and Association and creates a double helix structure from a single strand input
Stores the DNA info per band seperately in two arrays. These arrays are populated when DNA is construcuted using the overloaded contructor

Variables:
LtoRHelix NucleicAcid[] - Holds Left band's DNA strand Nucleic Acid Objects in an Array
RtoLHelix NucleicAcid[] - Holds Right band's DNA strand Nucleic Acid Objects in an Array

Functions:
Default Constructor - sets both instance arrays to null
DNA(String strand) - takes in a string of one band of DNA and populates both the left and right Nucleic Acid Bands using it

print() - prints out all Nucleic Acid Descriptions for both left and right bands using its print method
highestMolarMass() - Traverses both arrays to find and print the highest Molar Mass and its index
totalDensity() - Calculates and prints the total Density of all Nucleic Acid bases in both bands

helper methods:
createNucleicAcidObject(char baseChar) - Creates and returns a new NucleicAcid object based on the character input 
getComplementaryBase(char base) - Given a char input, returns a complementary new base object based on DNA pairing rules 
LtoRHelixPopulate() -Populates the LtoRHelix array of NucleicAcid objects by parsing the input strand string 


*/
public class DNA {
    // Containment: DNA holds (contains) multiple NucleicAcid objects in arrays
    private NucleicAcid[] LtoRHelix;
    private NucleicAcid[] RtoLHelix;

    //Default Constructor: Initializes properties to null 
    public DNA() {
        this.LtoRHelix = null;
        this.RtoLHelix = null;
    }

    /**
     * Overloaded constructor: Receives a strand string, populates LtoRHelix, and then populates RtoLHelix with complementary bases 
     * strand (String) - The input DNA sequence to be parsed (e.g., "ATGCCTAGGATCAG")
     */
    public DNA(String strand) {
        // Association: Calling LtoRHelixpopulate and passing 'strand' by reference
        this.LtoRHelixpopulate(strand);
        
        // Populating the complementary - looping through LtoRHelix and filling in RtoLHelix
        if (LtoRHelix != null) { //Array is initially null so just initializing it before populating
            RtoLHelix = new NucleicAcid[LtoRHelix.length];
            for (int i = 0; i < LtoRHelix.length; i++) {
                // Determine the base of the LtoR strand
                String base = LtoRHelix[i].getName();
                
                // Determine the complementary base by extracting the first letter and create a new NucleicAcid object
                RtoLHelix[i] = getComplementaryBase(base.charAt(0));
            }
        }
    }

    /**
     * Creates and returns a new NucleicAcid object based on the character input 
     * This is a helper method to easily assign the correct chemical data 
     * baseChar (char) -  The base character ('A', 'T', 'G', or 'C') 
     * return (Nucleic Acid) - A new NucleicAcid object with its chemical properties that complements input 
     */
    private NucleicAcid createNucleicAcidObject(char baseChar) {
        switch (baseChar) {
            case 'A': // Adenine
                return new NucleicAcid("Adenine", "C5H5N5", 135.13f, 1.6f);
            case 'T': // Thymine
                return new NucleicAcid("Thymine", "C5H6N2O2", 126.11f, 1.2f);
            case 'G': // Guanine
                return new NucleicAcid("Guanine", "C5H5N5O", 151.13f, 2.2f);
            case 'C': // Cytosine
                return new NucleicAcid("Cytosine", "C4H5N3O", 111.10f, 1.6f);
            default:
                // In case we do, return an empty Nucleic Acid and print error
                System.out.println("Error: Invalid base character: " + baseChar);
                return new NucleicAcid(); 
        }
    }

    /**
     * Method to return a complementary base based on DNA pairing rules 
     * Rules: A <-> T | C <-> G 
     * base (char) - The base character from LtoR helix 
     * compBase (char) - a temp variable to store the complementary base char
     * return (Nucleic Acid) - a new complementary base object returned by createNucleicAcidObject()
     */
    private NucleicAcid getComplementaryBase(char base) {
        char compBase;
        switch (base) {
            case 'A': compBase = 'T'; break; //Adenine -> Thymine
            case 'T': compBase = 'A'; break; //Thymine -> Adenine
            case 'C': compBase = 'G'; break; //Cytosine -> Guanine
            case 'G': compBase = 'C'; break; //Guanine -> Cytosine
            default: compBase = ' '; // Invalid Input Letter - this will be handled my createNAObject 
        }
        return this.createNucleicAcidObject(compBase);
    }

    /**
     * Populates the LtoRHelix array of NucleicAcid objects by parsing the input strand string 
     * strand (String) - The input DNA sequence string 
     */
    public void LtoRHelixpopulate(String strand) {
        int size = strand.length();
        LtoRHelix = new NucleicAcid[size];

        for (int i = 0; i < size; i++) {
            char baseChar = strand.toUpperCase().charAt(i);
            // Create a NucleicAcid object for each character and store it
            this.LtoRHelix[i] = createNucleicAcidObject(baseChar);
        }
        System.out.println("\nLtoR Helix populated -- Size: " + size);
    }

    /**
     * Iterates through both LtoRHelix and RtoLHelix and prints the properties
     * of each contained NucleicAcid object using the object's print method 
     */
    public void print() {
        if (LtoRHelix == null || RtoLHelix == null) {
            System.out.println("DNA Helix is not initialized.");
            return;
        }

        System.out.println("\n==================================================");
        System.out.println("            DNA DOUBLE HELIX STRUCTURE            \n");

        // Print header for alignment
        System.out.printf("%-10s | %-15s | %-15s\n", "Index", "LtoR Base", "RtoL Base");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < LtoRHelix.length; i++) {
            String lBase = LtoRHelix[i].getName();
            String rBase = RtoLHelix[i].getName();
            System.out.printf("%-10d | %-15s | %-15s\n", i, lBase, rBase);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Detailed Nucleic Acid Properties:");
        
        // Print details for all bases in both helices
        for (int i = 0; i < LtoRHelix.length; i++) {
            System.out.println("\n--- Index " + i + " LtoR Helix ---");
            LtoRHelix[i].print(); // Association: Calling print() on a contained object
            System.out.println("\n--- Index " + i + " RtoL Helix ---");
            RtoLHelix[i].print(); // Association: Calling print() on a contained object :)
        }
    }

    /**
     * Traverses both arrays to find and print the highest Molar Mass and its index 
     * Demonstrates Association by accessing the Molar Mass property of the NucleicAcid objects 
     */
    public void highestMolarMass() {
        if (LtoRHelix == null || RtoLHelix == null) return;

        float highestMass = 0.0f;
        int highestIndex = -1;
        String highestHelix = "";

        // Check LtoR Helix
        for (int i = 0; i < LtoRHelix.length; i++) {
            // Association: Calling getMolarMass() on a contained object
            if (LtoRHelix[i].getMolarMass() > highestMass) {
                highestMass = LtoRHelix[i].getMolarMass();
                highestIndex = i;
                highestHelix = "LtoRHelix (" + LtoRHelix[i].getName() + ")";
            }
        }

        // Check RtoL Helix (only need to check against the current highest)
        for (int i = 0; i < RtoLHelix.length; i++) {
            // Association: Calling getMolarMass() on a contained object
            if (RtoLHelix[i].getMolarMass() > highestMass) {
                highestMass = RtoLHelix[i].getMolarMass();
                highestIndex = i;
                highestHelix = "RtoLHelix (" + RtoLHelix[i].getName() + ")";
            }
        }

        System.out.println("\n==================================================");
        System.out.println("          HIGHEST NUCLEIC ACID MOLAR MASS         ");
        System.out.printf("Highest Molar Mass: %.3f g/mol\n", highestMass);
        System.out.printf("Found at Index %d in %s\n", highestIndex, highestHelix);
        System.out.println("==================================================");
    }

    /**
     * Calculates and prints the total Density of all Nucleic Acid bases in both bands
     * Precondition is that both the left and right bands are populated otherwise this will return null
     */
    public void totalDensity() {
        if (LtoRHelix == null || RtoLHelix == null) return;

        float totalDensity = 0.0f;

        // Sum densities from LtoR Helix
        for (NucleicAcid base : LtoRHelix) { //Short hand for calling for loop iterating through L or R Helixes
            // Association: Calling getDensity() on a contained object
            totalDensity += base.getDensity();
        }

        // Sum densities from RtoL Helix
        for (NucleicAcid base : RtoLHelix) {
            // Association: Calling getDensity() on a contained object
            totalDensity += base.getDensity();
        }

        System.out.println("\n==================================================");
        System.out.println("              TOTAL DNA DENSITY                   ");
        System.out.printf("Total Density (All Bases): %.3f g/cm3\n", totalDensity);
        System.out.println("==================================================");
    }
}
