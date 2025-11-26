package exception;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class StudentGradingException extends Exception {
    private int errorNo;
    private String errorMessage;

    public StudentGradingException(int errorNo, String errorMessage) {
        super(errorMessage);
        this.errorNo = errorNo;
        this.errorMessage = errorMessage;
    }

    // Req 1: Logs exceptions in a text file
    public void logException() {
        String logFile = "exception_log.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write("Timestamp: " + new Date().toString());
            writer.write(" | Error " + errorNo + ": " + errorMessage);
            writer.newLine();
            System.out.println("Exception logged to " + logFile);
        } catch (IOException e) {
            System.out.println("Could not write to log file.");
        }
    }

    // Req 1: Fix at least one exception
    // This method returns a "fixed" filename if the file was missing
    public String fixMissingFile() {
        System.out.println("Attempting to fix missing file error...");
        // In a real app, this might prompt the user. Here we return the default.
        return "StudentData.txt";
    }

    public int getErrorNo() {
        return errorNo;
    }
}