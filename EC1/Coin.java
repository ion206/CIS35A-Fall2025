import java.util.Random;

public class Coin {
    private String sideUp;
    private Random random;

    // Constructor
    public Coin() {
        random = new Random();
        toss(); // Randomly determine the initial side
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