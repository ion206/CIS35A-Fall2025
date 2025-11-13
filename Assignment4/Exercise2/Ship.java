/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 4 - Exercise 2
Due Date: November 12th, 2025
Date Submitted: November 12th, 2025


Parent Class: Ship
Contains properties common to all types of Ships
Has Various properties like floating, capacity, length, etc.
*/
public class Ship {
    // Ship Properties
    private boolean floating;
    private int capacity;
    private double length;
    private double width;
    protected String name; // Protected for potential specialized child use
    private double height;
    private String origin;
    private String departureDate;
    private String arrivalDate;
    private String departingPort;
    private String arrivalPort;
    private String owner;

    /**
     * Constructor for Ship (Base Class)
     */
    public Ship(String name, int capacity, double length, double width, double height, String origin, String owner) {
        this.name = name;
        this.capacity = capacity;
        this.length = length;
        this.width = width;
        this.height = height;
        this.origin = origin;
        this.owner = owner;
        this.floating = true; // Assume true on creation
        this.departureDate = "N/A";
        this.arrivalDate = "N/A";
        this.departingPort = "N/A";
        this.arrivalPort = "N/A";
    }

    // --- Core Methods ---
    
    /*
     * Demonstrates a standard behavior (not overridden)
     */
    public void move() {
        System.out.printf("  [Status]: %s is currently traveling from %s to %s.\n", 
            this.name, this.departingPort, this.arrivalPort);
    }
    
    /*
     * Prints the generic details of the Ship. This method will be overridden 
     * in child classes to demonstrate polymorphism
     */
    public void printDetails() {
        System.out.println("--------------------------------------------------");
        System.out.printf("VESSEL TYPE: %s\n", this.getClass().getSimpleName());
        System.out.printf("Name: %s | Owner: %s\n", name, owner);
        System.out.printf("Dimensions: %.1f m (L) x %.1f m (W) x %.1f m (H)\n", length, width, height);
        System.out.printf("Max Capacity (General): %d units\n", capacity);
        System.out.printf("Operational Status: %s\n", floating ? "Afloat" : "Sunk");
    }

    // --- Accessor/Mutator for dates and ports (Association) ---
    public void scheduleVoyage(String depPort, String arrPort, String depDate, String arrDate) {
        this.departingPort = depPort;
        this.arrivalPort = arrPort;
        this.departureDate = depDate;
        this.arrivalDate = arrDate;
    }
    
    // Getters for name and capacity (used by child print methods)
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
}