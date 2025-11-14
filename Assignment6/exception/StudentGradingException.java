package exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Custom exception class for centralized error logging and handling (Req 1).
 * Logs exceptions to 'exception_log.txt'.
 */
public class StudentGradingException extends Exception {
    private static final long serialVersionUID = 1L;
    private int errorNo;
    private String errorMsg;
    private static final String LOG_FILE = "exception_log.txt";

    public StudentGradingException(int errorNo, String errorMsg) {
        super(errorMsg);
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
        logException(); // Centralize capture and log upon creation
    }
    
    // --- Accessors ---
    public int getErrorNo() { return errorNo; }
    public String getErrorMsg() { return errorMsg; }

    /**
     * Centralized logging method. Appends the exception details to a log file.
     */
    public void logException() {
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            
            pw.println("--------------------------------------------------");
            pw.println("Timestamp: " + timestamp);
            pw.println("Error Code: " + this.errorNo);
            pw.println("Error Message: " + this.errorMsg);
            pw.println("--------------------------------------------------");
            
        } catch (IOException ioException) {
            System.err.println("FATAL: Could not write to exception log file: " + ioException.getMessage());
        }
    }

    /**
     * Fixes the specific exception where a score is outside the valid range (0-100).
     * @param invalidScore The score to fix.
     * @return The fixed score (50).
     */
    public static int fixInvalidScore(int invalidScore) {
        System.out.println("\n[Exception Fix]: Invalid score (" + invalidScore + ") detected. Setting score to default (50).");
        return 50;
    }
}