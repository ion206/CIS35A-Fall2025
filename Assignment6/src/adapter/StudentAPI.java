package adapter;

public interface StudentAPI {
    // 1. Print student statistics
    public void printStatistics();
    
    // 2. Print score for a given student id
    public void printScore(int studentId);
}