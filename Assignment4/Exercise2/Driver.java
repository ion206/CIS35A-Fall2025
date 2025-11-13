/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 4 - Exercise 2, Driver Program

Driver to demonstrate Inheritance and Polymorphism with Ship classes.
*/
public class Driver {
    public static void main(String[] args) {
        System.out.println("--- Exercise 2: Ship Inheritance and Polymorphism Demo ---");
        
        // 1. Create instances of all three classes
        
        // Base Ship
        Ship basicShip = new Ship("The Wanderer", 100, 50.5, 10.2, 8.0, 
                                  "Gibraltar", "NaviCo Inc.");
        basicShip.scheduleVoyage("Port A", "Port B", "10/10/2025", "10/15/2025");
        
        // Cargo Ship
        CargoShip cargoCarrier = new CargoShip("Global Freighter", 
                                               200000, 300.0, 40.0, 30.0, 
                                               "Rotterdam", "MegaLogistics",
                                               "Containerized Goods", 4, 98000000.00);
        cargoCarrier.scheduleVoyage("Tokyo", "LA", "11/01/2025", "11/14/2025");

        // Cruise Ship
        String[] luxuryServices = {"Spa", "Casino", "Concert Hall", "Water Park"};
        CruiseShip pleasureLiner = new CruiseShip("The Neptune Dream", 
                                                  6000, 350.0, 45.0, 55.0, 
                                                  "Miami", "Cruises R Us",
                                                  1500.00, 2500, "Luxury Resort", luxuryServices);
        pleasureLiner.scheduleVoyage("Miami", "Bahamas", "12/20/2025", "12/25/2025");
        
        // 2. Create a Ship array and assign different types to it (Upcasting)
        Ship[] fleet = new Ship[3];
        fleet[0] = basicShip;
        fleet[1] = cargoCarrier;
        fleet[2] = pleasureLiner;
        
        System.out.println("\n==================================================");
        System.out.println("  DEMONSTRATING POLYMORPHISM (Calling printDetails)");
        System.out.println("==================================================");

        // 3. Loop through the array and call the overridden method
        // At runtime, the JVM knows the actual object type and calls the correct version.
        for (Ship ship : fleet) {
            ship.printDetails(); // Polymorphism in action!
        }
        
        System.out.println("\n==================================================");
        System.out.println(" DEMONSTRATING NON-OVERRIDDEN METHOD (Calling move)");
        System.out.println("==================================================");
        
        // 4. Call a non-overridden method (all use the base Ship version)
        for (Ship ship : fleet) {
            ship.move();
        }
    }
}