package adapter;

/**
 * StudentAPI Interface (Req 3)
 * Defines the API contract.
 */
public interface StudentAPI {
    
    /**
     * Prints the summary statistics (High, Low, Average) for all 5 quizzes.
     */
    void printStudentStatistics();
    
    /**
     * Prints the scores for a specific student ID.
     * @param SID The four-digit student ID.
     */
    void printScoreForStudent(int SID);
}