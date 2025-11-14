package driver;

import exception.StudentGradingException;
import util.FileIO;
import util.StudentGrade;
import adapter.StudentAPI;
import adapter.StudentAPIImpl;
import Student;
import Statistics;

/**
 * Driver 3: Demonstrates API Adapter Usage (Req 3)
 * - Loads data and creates the StudentGrade object.
 * - Creates an instance of StudentAPIImpl (the adapter).
 * - Calls the interface methods to print reports.
 */
public class Driver3 {
    private static final String DATA_FILE = "data.txt";
    private static final int MAX_STUDENTS = 40;
    
    public static void main(String[] args) {
        System.out.println("--- Driver 3: API Adapter Demo (Req 3) ---");
        
        FileIO fileUtility = new FileIO();
        Statistics stats = new Statistics();
        Student[] students = new Student[MAX_STUDENTS];
        StudentGrade gradeReport = null;

        try {
            // 1. Setup: Load and process data
            students = fileUtility.readFile(DATA_FILE, students);
            stats.findlow(students);
            stats.findhigh(students);
            stats.findavg(students);
            gradeReport = new StudentGrade(students, stats);
            
            // 2. Create the API Implementation (Adapter)
            // The program uses the implementation class, but interacts via the interface.
            StudentAPI api = new StudentAPIImpl(gradeReport);
            
            // 3. Use the API to fulfill the required functionality
            
            // Req 3.1: Print student statistics
            api.printStudentStatistics();
            
            // Req 3.2: Print score for a given student id (Test existing ID: 4532)
            api.printScoreForStudent(4532);
            
            // Test non-existing ID
            api.printScoreForStudent(9999);
            
        } catch (StudentGradingException e) {
            System.err.println("Fatal Error during setup (Logged): " + e.getErrorMsg());
        }
    }
}