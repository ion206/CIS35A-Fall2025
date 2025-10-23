/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 2
Due Date: October 28th, 2025
Date Submitted: October 28th, 2025


Assignment 2 Part 1 - Human Genome OOP


Human Genome Class
Design:
 * Defines the blueprint for a human genetic code object,
 * including properties like genome name, gene count, chromosome count, and cell count (in trillions)
 * 
 * Variables:
 * name (string) The identifying name for the genome (e.g., "Human Bob")
 * genes (int) The total number of genes in the genome (e.g., 20000)
 * chromosomes (int) The number of chromosomes (e.g., 46)
 * cellsTrillions (double) The estimated number of cells in trillions
 * 
 * Functions
 * Has overloaded and default contructors
 * Getter and Setter Methods for all vars
 * print() - prints the current state of all instance vars
 */
public class HumanGenome {
    // Private vars for instance variables
    private String genomeName;
    private int numberOfGenes;
    private int numberOfChromosomes;
    private double numberOfCellsTrillions;
    // For number of cells, its more efficient to keep it as a double with trillions unit rather than having all those places

    /**
     * Overloaded Constructor to initialize a HumanGenome object with all required properties
     * name (string) The identifying name for the genome (e.g., "Human Bob")
     * genes (int) The total number of genes in the genome (e.g., 20000)
     * chromosomes (int) The number of chromosomes (e.g., 46)
     * cellsTrillions (double) The estimated number of cells in trillions
     */
    public HumanGenome(String name, int genes, int chromosomes, double cellsTrillions) {
        this.genomeName = name;
        this.numberOfGenes = genes;
        this.numberOfChromosomes = chromosomes;
        this.numberOfCellsTrillions = cellsTrillions;
    }
    /* 
     * Default contructor
     * Sets Name to 'None' and all instance vars to 0
     */
    public HumanGenome() {
        this.genomeName = "None";
        this.numberOfGenes = 0;
        this.numberOfChromosomes = 0;
        this.numberOfCellsTrillions = 0;
    }

    //     Getter Functions    
    public String getGenomeName() {
        return genomeName;
    }
    public int getNumberOfGenes() {
        return numberOfGenes;
    }

    public int getNumberOfChromosomes() {
        return numberOfChromosomes;
    }

    public double getNumberOfCellsTrillions() {
        return numberOfCellsTrillions;
    }

    // Setter Functions   

    public void setGenomeName(String genomeName) {
        this.genomeName = genomeName;
    }

    public void setNumberOfGenes(int numberOfGenes) {
        this.numberOfGenes = numberOfGenes;
    }

    public void setNumberOfChromosomes(int numberOfChromosomes) {
        this.numberOfChromosomes = numberOfChromosomes;
    }

    public void setNumberOfCellsTrillions(double numberOfCellsTrillions) {
        this.numberOfCellsTrillions = numberOfCellsTrillions;
    }

    /**
     * Prints the value of all properties with system.out.printf
     * Displays property name and its value on separate lines
     */
    public void print() {
        System.out.printf("--------------------------------------------------\n");
        System.out.printf("%-30s: %s\n", "Genome Name", this.genomeName);
        System.out.printf("--------------------------------------------------\n");
        System.out.printf("%-30s: %d\n", "Number of Genes", this.numberOfGenes);
        System.out.printf("%-30s: %d\n", "Number of Chromosomes", this.numberOfChromosomes);
        // Use a format specifier for floating-point numbers so it has two decimal places
        System.out.printf("%-30s: %.2f Trillion\n", "Number of Cells", this.numberOfCellsTrillions);
        System.out.printf("--------------------------------------------------\n");
    }
}
