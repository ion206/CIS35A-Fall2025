public class Part2 {

    /**
     * Approximates the square root of a non-negative number 'n' using the Babylonian method.
     * * The process is iterative and uses the formula:
     * nextGuess = (lastGuess + n / lastGuess) / 2
     * * The approximation stops when the absolute difference between the new guess 
     * (nextGuess) and the previous guess (lastGuess) is less than the tolerance (0.0001).
     * * @param n The number for which to calculate the square root (must be long).
     * @return The approximated square root as a double.
     */
    public static double sqrt(long n) {
        // Input validation for non-negative numbers.
        if (n < 0) {
            throw new IllegalArgumentException("Cannot compute the square root of a negative number.");
        }
        if (n == 0) {
            return 0.0;
        }

        // 1. Set the initial guess. The problem suggests starting with 1.
        double lastGuess = 1.0;
        double nextGuess;

        // Define the convergence tolerance as specified in the problem (0.0001).
        final double TOLERANCE = 0.0001;

        // Loop until the difference between the guesses is negligible.
        while (true) {
            // 2. Calculate the next guess using the Babylonian formula.
            // We cast 'n' to double to ensure floating-point division.
            nextGuess = (lastGuess + (double)n / lastGuess) / 2.0;

            // 3. Check for the stopping condition: 
            // |nextGuess - lastGuess| < 0.0001
            if (Math.abs(nextGuess - lastGuess) < TOLERANCE) {
                // Convergence achieved. The current nextGuess is the result.
                return nextGuess;
            }

            // 4. If not converged, update lastGuess for the next iteration.
            // nextGuess becomes the new lastGuess.
            lastGuess = nextGuess;
        }
    }

    /**
     * Main method for testing the sqrt implementation.
     */
    public static void main(String[] args) {
        long n1 = 4;
        long n2 = 16;
        long n3 = 50;
        long n4 = 100000;
        
        System.out.println("--- Babylonian Square Root Method Test ---");

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
    }
}
