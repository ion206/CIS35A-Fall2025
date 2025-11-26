public class Simulation {
    
    // Accepts a Coin object and tosses it 20 times
    public void toss(Coin c) {
        int headsCount = 0;
        int tailsCount = 0;
        int totalTosses = 20;

        // Loop to toss the coin 20 times
        for (int i = 0; i < totalTosses; i++) {
            c.toss();
            
            // Check the result and increment counters
            if (c.getSideUp().equalsIgnoreCase("heads")) {
                headsCount++;
            } else {
                tailsCount++;
            }
            // Optional: Print individual toss result
            // System.out.println("Toss " + (i + 1) + ": " + c.getSideUp());
        }

        // Display the results
        System.out.println("Simulation Results:");
        System.out.println("Total Tosses: " + totalTosses);
        System.out.println("Heads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
        System.out.println("-------------------------------");
    }
}