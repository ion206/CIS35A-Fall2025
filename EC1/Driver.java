/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
EC1
Due Date: December 3rd, 2025
Date Submitted: December 3rd, 2025


Driver.java
Runs Simulated coin flips on various coins and prints their results 


Functions:
+ static void main(String[]): runs 3 Coin flip simulations and prints their results
+ Driver(): Default Contructor
*/

public class Driver {

    public static void main(String[] args) {
        // Create a Simulation Object
        Simulation s1 = new Simulation();

        // Test Case 1: Quarter
        System.out.println("--- Test Case 1: Quarter ---");
        Coin quarter = new Coin();
        s1.printStats(quarter, 20); //toss quarter 20 times and printStats

        // Test Case 2: Dime
        System.out.println("--- Test Case 2: Dime ---");
        Coin dime = new Coin();
        s1.printStats(dime, 20);//toss dime 20 times and printStats

        // Test Case 3: Nickel
        System.out.println("--- Test Case 3: Nickel ---");
        Coin nickel = new Coin();
        s1.printStats(nickel, 20); //toss nickel 20 times and printStats

    }

    public Driver(){
        //Default Contructor
    }
}