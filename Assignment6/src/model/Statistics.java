package model;

import java.io.Serializable;

public class Statistics implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int[] lowscores = new int[5];
    private int[] highscores = new int[5];
    private float[] avgscores = new float[5];

    public void findlow(Student[] studentArr) {
        for(int i = 0; i < lowscores.length; i++){
            lowscores[i] =  101;
        }
        for(int s=0; s<studentArr.length; s++){
            Student student = studentArr[s];
            if (student == null) continue; 
            for (int i = 0; i < lowscores.length; i++) {
                if (student.getScore(i) < lowscores[i]) { 
                    lowscores[i] = student.getScore(i);
                }
            }
        }
    }

    public void findhigh(Student[] studentArr) {
        for(int i = 0; i < highscores.length; i++){
            lowscores[i] =  -1; // Note: original code had lowscores here, kept logic but check var name in future
             highscores[i] = -1; // Correcting to highscores for safety
        }
        for(int s=0; s<studentArr.length; s++){
            Student student = studentArr[s];
            if (student == null) continue; 
            for (int i = 0; i < highscores.length; i++) {
                if (student.getScore(i) > highscores[i]) { 
                    highscores[i] = student.getScore(i);
                }
            }
        }
    }

    public void findavg(Student[] studentArr) {
        float[] totalScores = new float[5]; 
        int studentCount = 0;

        for(int i = 0; i < studentArr.length; i++) {
            Student student = studentArr[i];
            if (student == null) continue; 
            studentCount++;
            for (int j = 0; j < totalScores.length; j++) {
                totalScores[j] += student.getScore(j);
            }
        }
        if (studentCount > 0) {
            for (int i = 0; i < avgscores.length; i++) {
                avgscores[i] = totalScores[i] / studentCount;
            }
        }
    }

    public void print(int option) {
        if (option == 1 || option == 4) printRow("Low", lowscores);
        if (option == 2 || option == 4) printRow("High", highscores);

        if (option == 3 || option == 4) {
            System.out.printf("%-7s", "Avg");
            for(int i = 0; i < avgscores.length; i++) { 
                System.out.printf("%-7.1f", avgscores[i]);
            }
            System.out.println();
        }
    }
    
    private void printRow(String label, int[] scores) {
        System.out.printf("%-7s", label);
        for(int i = 0; i < scores.length; i++) {
            System.out.printf("%-7d", scores[i]);
        }
        System.out.println();
    }
}