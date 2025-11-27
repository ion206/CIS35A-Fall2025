/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
EC1
Due Date: December 3rd, 2025
Date Submitted: December 3rd, 2025


Simulation.java
Class to run coin flips on given coins and record thier states 


Functions:
+ tossForSimulation(Coin): Runs a coin toss on a given coin and prints the result
+ printStats(Coin, count): Accepts a Coin object and tosses it count number of times
+ Simulation(): Default Contructor
*/


public class Simulation {
    // Accepts a Coin object and tosses it count number of times
    // then prints the result
    public void printStats(Coin c, int count) {
        int headsCount = 0;
        int tailsCount = 0;
        
        // Loop to toss the coin 20 times
        for (int i = 0; i < count; i++) {
            if (tossForSimulation(c).equalsIgnoreCase("heads")) {
                headsCount++;
            } else {
                tailsCount++;
            }
            // Option: Print individual toss result
            // System.out.println("Toss " + (i + 1) + ": " + c.getSideUp());
        }

        // Display the results
        System.out.println("Simulation Results:");
        System.out.println("Total Tosses: " + count);
        System.out.println("Heads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
        System.out.println("-------------------------------");
    }

    //Runs a coin toss and prints the recorded result
    public String tossForSimulation(Coin c){
        c.toss();  
        return c.getSideUp();
    }

    public Simulation(){
        //Default Contructor
    }
}