/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 1
Due Date: October 12th, 2025
Date Submitted: October 12th, 2025
 */


//Lab 1 Part 2 - Square Root Approximation (Babylonian Method)

 /**
     * Function sqrt(long n) Approximates the square root of a non-negative number 'n' using the Babylonian method
     * The process is iterative and uses the formula:
     *  nextGuess = (lastGuess + n / lastGuess) / 2
     * The approximation stops when the absolute difference between the new guess (nextGuess) and the previous guess (lastGuess) is less than the tolerance (0.0001)
     * 
     * Tests runs of this code can be found in testrun2.txt
*/


public class Part2 {
    public static double sqrt(long n) {
        /*
         * n (long) - The number for which to calculate the square root
         * return (double) - Approximated square root of n (if n is below 0, will return -1)
         */
        // Input validation for non-negative numbers.
        if (n < 0) {
            //Using an if statement to handle the negative number case, we just return -1 in that case
            System.out.printf("ERROR: Cannot compute the square root of a negative number!!\n");
            return -1.0;
        }
        if (n == 0) {
            //If n is 0, we can just return 0, all these steps ensure that all numbers being processed are positive and above 0
            return 0.0;
        }

        //Setting the initial guess - The problem suggests starting with 1
        double lastGuess = 1.0;
        double nextGuess;

        // Define the convergence tolerance - Problem recommended that we use 0.0001
        final double TOLERANCE = 0.0001;

        // Loop until the difference between the guesses is below TOLERANCE
        while (true) {
            // Calculate the next guess using the Babylonian formula
            // Casting n to double to ensure floating-point division
            nextGuess = (lastGuess + (double)n / lastGuess) / 2.0;

            // Check for the stopping condition: 
            // |nextGuess - lastGuess| < 0.0001
            if (Math.abs(nextGuess - lastGuess) < TOLERANCE) {
                // Convergence achieved - The current nextGuess is the result and we can return that
                return nextGuess;
            }

            // If not converged, update lastGuess for the next iteration
            // nextGuess becomes the new lastGuess
            lastGuess = nextGuess;
        }
    }

    /*
     * Wrote a few test cases for testing the sqrt method in main
     * Displays function result with the Math.sqrt(n) result
     * Output of this code is what is found in testrun2.txt
     */
    public static void main(String[] args) {
        long n1 = 4;
        long n2 = 16;
        long n3 = 50;
        long n4 = 100000;
        
        System.out.printf("--- Babylonian Square Root Method Test ---\n");

        // Test case 1: Perfect square
        double result1 = sqrt(n1);
        System.out.printf("sqrt(%d): Calculated= %.4f | Exact= %.4f\n", n1, result1, Math.sqrt(n1));

        // Test case 2: Perfect square
        double result2 = sqrt(n2);
        System.out.printf("sqrt(%d): Calculated= %.4f | Exact= %.4f\n", n2, result2, Math.sqrt(n2));

        // Test case 3: Non-perfect square
        double result3 = sqrt(n3);
        System.out.printf("sqrt(%d): Calculated= %.4f | Exact= %.4f\n", n3, result3, Math.sqrt(n3));

        // Test case 4: Large number
        double result4 = sqrt(n4);
        System.out.printf("sqrt(%d): Calculated= %.4f | Exact= %.4f\n", n4, result4, Math.sqrt(n4));
        
        // Test case 5: Edge case n=0
        long n5 = 0;
        double result5 = sqrt(n5);
        System.out.printf("sqrt(%d): Calculated= %.4f | Exact= %.4f\n", n5, result5, Math.sqrt(n5));

        // Test case 5: Edge case n=0
        long n6 = -1;
        double result6 = sqrt(n6);
        System.out.printf("sqrt(%d): Calculated= %.4f | Exact= %.4f\n", n6, result6, Math.sqrt(n6));
    }
}
