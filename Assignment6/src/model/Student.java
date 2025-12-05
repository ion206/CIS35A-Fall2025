/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 4th, 2025
Date Submitted: December 4th, 2025


Student.java
Base Student Object from Assignment 5 - Made Serializable 
Part of model Package

Class to represent a Student, holding his/her ID test scores as well as ways to access and set them

Two Main Instance Vars:
int SID - Student ID Number (must be four digitss)
int[] scores - the list of 5 quiz scores the Student earned

Contains:
Overloaded and Default Constructors
Getters and Setter for SID and Scores
print - prints the Student data in a special formatted row

*/

package model;

import java.io.Serializable;

public class Student implements Serializable {
    // Serial Version UID for serialization compatibility
    private static final long serialVersionUID = 1L;

    private int SID; //Student ID Number
    private int[] scores; //The list of 5 quiz scores


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
    public int getSID() {
        return SID;
    }

    public int[] getScores() {
        return scores;
    }

    public int getScore(int index){
        return scores[index];
    }

    // --- Setters ---
    public void setSID(int SID) {
        this.SID = SID;
    }

    //Given an array of scores, set this Students scores those that
    public void setScores(int[] scores) {
        if (!(this.scores.length > 0)){
            //If Student scores hasn't been init yet, this initilizes it
            this.scores = new int[5];
        }
        if (scores.length == 5) {
            this.scores = scores;
        }
    }
    
    //Sets a given quiz score 
    //quizIndex (int) - the quiz number (0-4) to be set
    //score (int) - the score to set that quiz to 
    public void setScore(int quizIndex, int score) {
        if (quizIndex >= 0 && quizIndex < 5) {
            this.scores[quizIndex] = score;
        }
    }


    // Prints the student ID and all 5 scores in a single formatted line.
    public void print() {
        System.out.print(SID + ":  ");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-7d", scores[i]);
        }
        System.out.println();
    }
}