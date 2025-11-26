package driver;

import adapter.StudentAPI;
import adapter.StudentAPIImpl;

public class Driver3 {
    public static void main(String[] args) {
        System.out.println("--- Driver 3: Adapter/API Pattern ---");

        // 1. Instantiate the Implementation
        StudentAPI api = new StudentAPIImpl();

        // 2. Use API to print statistics
        api.printStatistics();
        
        System.out.println();

        // 3. Use API to print specific student score (Assuming 1234 exists in your text file)
        // If you don't have a specific ID in your file, change 1234 to an ID that exists
        api.printScore(1234); 
    }
}