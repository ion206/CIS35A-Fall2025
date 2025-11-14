package driver;

import exception.StudentGradingException;
import util.FileIO;
import Student;
import java.io.File;
import java.io.PrintWriter;

/**
 * Driver 1: Demonstrates custom Exception Handler (Req 1)
 * - Centralized logging
 * - Fixing an exception (Invalid Score Range)
 */
public class Driver1 {
    private static final String FILE_NAME_BAD = "data_bad.txt";
    private static final int MAX_STUDENTS = 40;

    /**
     * Creates a temporary file with a score error (120) to trigger the exception.
     */
    private static void createBadDataFile() {
        try (PrintWriter writer = new PrintWriter(FILE_NAME_BAD)) {
            writer.println("Stud Qu1 Qu2 Qu3 Qu4 Qu5");
            writer.println("1234 052 007 100 078 034");
            // Deliberate error: Score 120 (out of 100 range) for Q2 of student 9999
            writer.println("9999 090 120 090 077 030"); 
            writer.println("3124 100 045 020 090 070");
        } catch (Exception e) {
            System.err.println("Failed to create bad data file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Driver 1: Exception Handling Demo (Req 1) ---");
        
        // 1. Setup: Create a file that will intentionally cause an error
        createBadDataFile();
        
        FileIO fileUtility = new FileIO();
        Student[] students = new Student[MAX_STUDENTS];
        
        try {
            // Attempt to read the bad file, which will throw StudentGradingException
            // This demonstrates the custom exception replacing standard Java exceptions.
            fileUtility.readFile(FILE_NAME_BAD, students);

        } catch (StudentGradingException e) {
            // 2. Centralized Capture & Logging (Done automatically in e.logException() inside constructor)
            System.out.println("\n[Driver Capture]: Exception caught with Code " + e.getErrorNo());
            System.out.println("Error Message: " + e.getErrorMsg());
            System.out.println("--> Check 'exception_log.txt' for log details.");

            // 3. Fix the Exception (Demonstration for score out of bounds: Code 201)
            if (e.getErrorNo() == 201) { 
                int fixedScore = StudentGradingException.fixInvalidScore(120);
                System.out.println("The program would now attempt to continue processing with score: " + fixedScore);
            }
        } finally {
            // Cleanup the temporary file
            new File(FILE_NAME_BAD).delete();
        }
    }
}