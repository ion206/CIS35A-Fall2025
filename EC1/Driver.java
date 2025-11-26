public class Driver {

    public static void main(String[] args) {
        // Create a Simulation Object
        Simulation s1 = new Simulation();

        // Test Case 1: Quarter
        System.out.println("--- Test Case 1: Quarter ---");
        Coin quarter = new Coin();
        s1.toss(quarter);

        // Test Case 2: Dime
        System.out.println("--- Test Case 2: Dime ---");
        Coin dime = new Coin();
        s1.toss(dime);

        // Test Case 3: Nickel
        System.out.println("--- Test Case 3: Nickel ---");
        Coin nickel = new Coin();
        s1.toss(nickel);
    }
}