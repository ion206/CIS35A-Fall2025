/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 2
Due: Oct 28th 2025
Submitted: Oct 28th 2025

Assignment 2 Part 2 - Nucleic Acid OOP
 * NucleicAcid.java
 * 
 * Defines the class for a nucleic acid, which serves as a structural unit
 * in DNA and RNA. It includes chemical properties like formula, mass, and density
 * 
 * Varibles:
 * name (string) - name of the acid
 * chemicalFormula (string) - chemical formula of the acid 
 * molarMass (float) - the molar mass of the acid [g/mol]
 * density (float) - density of the object in [g/cm3]
 * 
 * Functions:
 * Overloaded and Deafult Constructors
 * Getter and Setter methods for all varaibles
 * print() - prints the current values for all variables in a well formatted way with units
 */
public class NucleicAcid {
    // Private variables
    private String name;
    private String chemicalFormula;
    private float molarMass;
    private float density;

    /*
     * Overloaded Constructor to initialize a NucleicAcid object.
     */
    public NucleicAcid(String name, String formula, float molarMass, float density) {
        this.name = name;
        this.chemicalFormula = formula;
        this.molarMass = molarMass;
        this.density = density;
    }

    //Default Contructor
    public NucleicAcid() {
        this.name = "NONE";
        this.chemicalFormula = "NONE";
        this.molarMass = 0.0f;
        this.density = 0.0f;
    }

    //Getter Methods 
    public String getName() {
        return name;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public float getMolarMass() {
        return molarMass;
    }

    public float getDensity() {
        return density;
    }

    //Setter Methods

    public void setName(String name) {
        this.name = name;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }

    public void setMolarMass(float molarMass) {
        this.molarMass = molarMass;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    // Prints the value of all properties using system.out.printf() with units
    public void print() {
        System.out.printf("\n\n==================================================\n");
        System.out.printf("NUCLEIC ACID: %s\n", this.name.toUpperCase());
        System.out.printf("==================================================\n");
        // Using float format specifier (%.3f) for precision on float properties
        System.out.printf("%-30s: %s\n", "Chemical Formula", this.chemicalFormula);
        System.out.printf("%-30s: %.3f g/mol\n", "Molar Mass", this.molarMass);
        System.out.printf("%-30s: %.3f g/cm3\n", "Density", this.density);
        System.out.printf("==================================================\n");
    }
}
