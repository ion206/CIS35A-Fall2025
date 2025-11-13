/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 4 - Exercise 2
Due Date: November 12th, 2025
Date Submitted: November 12th, 2025


CruiseShip.java
Child Class: CruiseShip
Extends Ship and adds passenger/luxury-specific properties and behaviors

Overrriden Contructor and printDetails Functions 
*/
public class CruiseShip extends Ship {
    // CruiseShip Properties
    private double ticketPrice;
    private int numberOfRooms;
    private String buffetMenu; // Simple string for menu description
    private String[] services; // Services array, what services the cruise has
    private String cruiseType; // e.g., Luxury, Family, Expedition

    /**
     * Constructor for CruiseShip. Calls super() for inherited properties.
     */
    public CruiseShip(String name, int capacity, double length, double width, double height, String origin, String owner,
                      double ticketPrice, int numberOfRooms, String cruiseType, String[] services) {
        // Calls the parent Ship constructor
        super(name, capacity, length, width, height, origin, owner);
        
        this.ticketPrice = ticketPrice;
        this.numberOfRooms = numberOfRooms;
        this.cruiseType = cruiseType;
        this.services = services;
        
        // Mock default property
        this.buffetMenu = "International Cuisine & Seafood Galore";
    }

    /**
     * Overridden method (Polymorphism) to display CruiseShip-specific details.
     */

    public void printDetails() {
        // Call the parent's printDetails method first
        super.printDetails(); 
        
        System.out.println("--- Cruise Specifics ---");
        System.out.printf("Cruise Type: %s | Rooms: %d\n", cruiseType, numberOfRooms);
        System.out.printf("Avg Ticket Price: $%,.2f\n", ticketPrice);
        System.out.printf("Primary Services: %s\n", String.join(", ", services));
        System.out.printf("Dining Theme: %s\n", buffetMenu);
        System.out.println("--------------------------------------------------");
    }
}