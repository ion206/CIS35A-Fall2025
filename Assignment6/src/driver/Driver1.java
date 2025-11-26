package driver;

import util.FileIO;
import model.Student;
import exception.StudentGradingException;

public class Driver1 {
    public static void main(String[] args) {
        System.out.println("--- Driver 1: Exception Handling ---");
        
        FileIO io = new FileIO();
        Student[] students = new Student[40];
        
        // 1. Trigger Exception by giving a wrong filename
        String badFilename = "DoesNotExist.txt";
        
        try {
            System.out.println("Attempting to read: " + badFilename);
            io.readFile(badFilename, students);
        } catch (StudentGradingException e) {
            // 2. Log the exception
            System.out.println("Caught Exception: " + e.getMessage());
            e.logException();
            
            // 3. Fix the exception (Req 1)
            // Use the fix method to get the correct filename
            String fixedFilename = e.fixMissingFile();
            System.out.println("Retrying with fixed filename: " + fixedFilename);
            
            try {
                // Retry logic
                io.readFile(fixedFilename, students);
                System.out.println("File read successfully after fix!");
                if(students[0] != null) students[0].print(); // Verify data
            } catch (StudentGradingException ex) {
                System.out.println("Fix failed.");
            }
        }
    }
}