/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
EC1
Due Date: December 3rd, 2025
Date Submitted: December 3rd, 2025


Coin.java
Class representing a coin that can be tossed for heads of tails

Instance vars:
- String sideup: Reprenting the current side that the coin is showing, randomized at start and flip
- Random random: Holds Random Class and Object for random calculations

Functions:
+ Coin: public default contructor, sets the sideup to random state
+ toss: Randomly selects 0 or 1 - 0 for heads, 1 for tails
+ getSideUp: Accessor for sideUp Variable
*/

import java.util.Random;

public class Coin {
    private String sideUp; //Either 'heads' or 'tails'
    private Random random;

    // Constructor
    public Coin() {
        random = new Random(); //Initialize Random Object
        this.toss(); // Randomly determine the initial side
    }

    // The toss method simulates the coin flip
    public void toss() {
        // 0 for heads, 1 for tails
        if (random.nextInt(2) == 0) {
            sideUp = "heads";
        } else {
            sideUp = "tails";
        }
    }

    // Accessor method to return the current side
    public String getSideUp() {
        return sideUp;
    }
}