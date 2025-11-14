/*
Student Class
Represents a single student with a unique ID and an array of 5 quiz scores.
*/
public class Student {
    private int SID;
    private int[] scores = new int[5];

    // --- Getters ---
    public int getSID() {
        return SID;
    }

    public int[] getScores() {
        return scores;
    }

    public int getScore(int quizIndex) {
        if (quizIndex >= 0 && quizIndex < 5) {
            return scores[quizIndex];
        }
        return -1; // Error value
    }

    // --- Setters ---
    public void setSID(int SID) {
        this.SID = SID;
    }

    public void setScores(int[] scores) {
        if (scores.length == 5) {
            this.scores = scores;
        }
    }
    
    public void setScore(int quizIndex, int score) {
        if (quizIndex >= 0 && quizIndex < 5) {
            this.scores[quizIndex] = score;
        }
    }

    /**
     * Prints the student ID and all 5 scores in a single formatted line.
     */
    public void print() {
        System.out.printf("%-7d", SID);
        for (int score : scores) {
            System.out.printf("%-7d", score);
        }
        System.out.println();
    }
}