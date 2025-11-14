import java.util.Arrays;

/*
Statistics Class
Computes and stores the high, low, and average scores for each of the five quizzes.
*/
public class Statistics {
    private int[] lowscores = new int[5];
    private int[] highscores = new int[5];
    private float[] avgscores = new float[5];

    /**
     * Finds the lowest score for each of the five quizzes and stores it in lowscores.
     * @param a The array of Student objects.
     */
    public void findlow(Student[] a) {
        // Initialize lowscores array with a maximum possible value (101 is higher than any score)
        Arrays.fill(lowscores, 101);

        for (Student student : a) {
            if (student == null) continue; // Skip unpopulated array slots

            for (int i = 0; i < 5; i++) {
                if (student.getScore(i) < lowscores[i]) {
                    lowscores[i] = student.getScore(i);
                }
            }
        }
    }

    /**
     * Finds the highest score for each of the five quizzes and stores it in highscores.
     * @param a The array of Student objects.
     */
    public void findhigh(Student[] a) {
        // Initialize highscores array with a minimum possible value (-1 is lower than any score)
        Arrays.fill(highscores, -1);

        for (Student student : a) {
            if (student == null) continue; // Skip unpopulated array slots

            for (int i = 0; i < 5; i++) {
                if (student.getScore(i) > highscores[i]) {
                    highscores[i] = student.getScore(i);
                }
            }
        }
    }

    /**
     * Finds the average score for each quiz and stores it in avgscores.
     * @param a The array of Student objects.
     */
    public void findavg(Student[] a) {
        float[] totalScores = new float[5];
        int studentCount = 0;

        for (Student student : a) {
            if (student == null) continue;
            studentCount++;

            for (int i = 0; i < 5; i++) {
                totalScores[i] += student.getScore(i);
            }
        }

        // Calculate the average by dividing the total score by the number of students
        if (studentCount > 0) {
            for (int i = 0; i < 5; i++) {
                avgscores[i] = totalScores[i] / studentCount;
            }
        }
    }

    /**
     * Prints the statistical information based on the option provided.
     * @param option 1-low, 2-high, 3-avg, 4-all.
     */
    public void print(int option) {
        if (option == 1 || option == 4) printRow("Low Score", lowscores);
        if (option == 2 || option == 4) printRow("High Score", highscores);
        
        if (option == 3 || option == 4) {
            // Print Average scores
            System.out.printf("%-7s", "Average");
            for (float avg : avgscores) {
                // Formatting to one decimal place for average
                System.out.printf("%-7.1f", avg);
            }
            System.out.println();
        }
    }
    
    /**
     * Helper method to print a single row of integer statistics.
     */
    private void printRow(String label, int[] scores) {
        System.out.printf("%-7s", label);
        for (int score : scores) {
            System.out.printf("%-7d", score);
        }
        System.out.println();
    }
}