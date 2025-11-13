/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 4 - Exercise 2
Due Date: November 12th, 2025
Date Submitted: November 12th, 2025


Child Class: CargoShip
Extends Ship and adds cargo-specific properties and behaviors

Overriden printDetails Function and Contructor
*/
public class CargoShip extends Ship {
    // CargoShip Properties
    private String cargoType;
    private String loadingMethod; // e.g., Crane, Roll-on/Roll-off
    private int numberOfCranes;
    private boolean contraband;
    private double cargoValue;

    /**
     * Constructor for CargoShip. Calls super() for inherited properties.
     */
    public CargoShip(String name, int capacity, double length, double width, double height, String origin, String owner,
                     String cargoType, int numberOfCranes, double cargoValue) {
        // Calls the parent Ship constructor
        super(name, capacity, length, width, height, origin, owner);
        
        this.cargoType = cargoType;
        this.numberOfCranes = numberOfCranes;
        this.cargoValue = cargoValue;
        
        // Mock default properties
        this.loadingMethod = "Gantry Crane";
        this.contraband = false;
    }

    /**
     * Overridden method (Polymorphism) to display CargoShip-specific details.
     */

    public void printDetails() {
        // Call the parent's printDetails method first
        super.printDetails(); 
        
        System.out.println("--- Cargo Specifics ---");
        System.out.printf("Cargo Type: %s | Value: $%,.2f\n", cargoType, cargoValue);
        System.out.printf("Loading Method: %s (Cranes: %d)\n", loadingMethod, numberOfCranes);
        System.out.printf("Hazard/Contraband Status: %s\n", contraband ? "CHECK REQUIRED" : "Clear");
        System.out.println("--------------------------------------------------");
    }
}