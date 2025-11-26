package model;

import java.io.Serializable;

public class Student implements Serializable {
    // Serial Version UID for serialization compatibility
    private static final long serialVersionUID = 1L;

    private int SID; 
    private int[] scores; 

    //Overloaded Constructor
    public Student(int ID, int[] scoreInput){
        this.SID = ID;
        this.scores = scoreInput;
    }

    //Default Constructor
    public Student(){
        this.SID = 0000;
        this.scores = new int[5];
    }

    // --- Getters ---
    public int getSID() { return SID; }
    public int[] getScores() { return scores; }
    public int getScore(int index){ return scores[index]; }

    // --- Setters ---
    public void setSID(int SID) { this.SID = SID; }

    public void setScores(int[] scores) {
        if (this.scores == null || this.scores.length == 0){
            this.scores = new int[5];
        }
        if (scores.length == 5) {
            this.scores = scores;
        }
    }
    
    public void setScore(int quizIndex, int score) {
        if (quizIndex >= 0 && quizIndex < 5) {
            this.scores[quizIndex] = score;
        }
    }

    public void print() {
        System.out.print(SID + ":  ");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-7d", scores[i]);
        }
        System.out.println();
    }
}