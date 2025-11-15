/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 5
Due Date: November 24th, 2025
Date Submitted: November 24th, 2025

Statistics.java
Statistics Class
Holds functions that Computes and stores the high, low, and average scores for each of the five quizzes

3 Main Instance Vars that are updated and then requested from when printed
lowscores - hold the lowest 5 scores of a Student[]
highscores - hold the highest 5 scores of a Student[]
avgscores - hold the average scores of each of the 5 quizzes in a Student[]

printRow - prints one of the above instance arrays with a given label
print(option) - prints certain instance arrays depending on the input (1 for only lows, 4 for all, etc.)
*/

public class Statistics {
    private int[] lowscores = new int[5];
    private int[] highscores = new int[5];
    private float[] avgscores = new float[5];

    // Finds the lowest score for each of the five quizzes and stores it in lowscores
    // Student[] studentArr -  The array of Student objects
    public void findlow(Student[] studentArr) {
        // Initialize lowscores array with a maximum possible value (101 is higher than any score)
        for(int i = 0; i < lowscores.length; i++){
            lowscores[i] =  101;
        }

        for(int s=0; s<studentArr.length; s++){
            Student student = studentArr[s];
            if (student == null) continue; // Skip unpopulated array slots

            for (int i = 0; i < lowscores.length; i++) {
                //compare each Student Quiz Score with the corresponding lowest quiz score
                if (student.getScore(i) < lowscores[i]) { 
                    lowscores[i] = student.getScore(i);
                }
            }
        }
    }

    
    // Finds the highest score for each of the five quizzes and stores it in highscores
    // Student[] studentArr -  The array of Student objects
    public void findhigh(Student[] studentArr) {
        // Initialize lowscores array with a maximum possible value (101 is higher than any score)
        for(int i = 0; i < lowscores.length; i++){
            lowscores[i] =  -1;
        }

        for(int s=0; s<studentArr.length; s++){
            Student student = studentArr[s];
            if (student == null) continue; // Skip unpopulated array slots

            for (int i = 0; i < lowscores.length; i++) {
                //compare each Student Quiz Score with the corresponding lowest quiz score
                if (student.getScore(i) > lowscores[i]) { 
                    lowscores[i] = student.getScore(i);
                }
            }
        }
    }

    
     // Finds the average score for each quiz and stores it in avgscores
     // Student[] studentArr - The array of Student objects
    public void findavg(Student[] studentArr) {
        float[] totalScores = new float[5]; //Storing as float[] for float division later
        int studentCount = 0;

        for(int i = 0; i < studentArr.length; i++) {
            Student student = studentArr[i];
            if (student == null) continue; //Skip empty entries
            studentCount++;

            for (int j = 0; j < totalScores.length; j++) {
                totalScores[j] += student.getScore(j);
            }
        }
        // Calculate the average by dividing the total score by the number of students
        if (studentCount > 0) {
            for (int i = 0; i < avgscores.length; i++) {
                avgscores[i] = totalScores[i] / studentCount;
            }
        }
    }

    // Prints the statistical information based on the option provided
    // int option - 1-low, 2-high, 3-avg, 4-all
    public void print(int option) {
        if (option == 1 || option == 4) printRow("Low", lowscores);
        if (option == 2 || option == 4) printRow("High", highscores);

        if (option == 3 || option == 4) {
            // Print Average scores
            System.out.printf("%-7s", "Avg");
            for(int i = 0; i < avgscores.length; i++) { 
                float avg = avgscores[i];
                // Formatting to one decimal place for average
                System.out.printf("%-7.1f", avg);
            }
            System.out.println();
        }
    }
    
    //Helper method to print a single row of integer statistics
    private void printRow(String label, int[] scores) {
        System.out.printf("%-7s", label);
        for(int i = 0; i < scores.length; i++) {
            int score = scores[i];
            System.out.printf("%-7d", score);
        }
        System.out.println();
    }
}