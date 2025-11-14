package driver;

import exception.StudentGradingException;
import util.FileIO;
import util.StudentGrade;
import Student;
import Statistics;

/**
 * Driver 2: Demonstrates Object Serialization (Req 2)
 * - Serializes the StudentGrade container object.
 * - Deserializes the object and verifies the content.
 */
public class Driver2 {
    private static final String DATA_FILE = "data.txt";
    private static final String SERIALIZED_FILE = "student_grade.ser";
    private static final int MAX_STUDENTS = 40;

    public static void main(String[] args) {
        System.out.println("--- Driver 2: Serialization Demo (Req 2) ---");

        FileIO fileUtility = new FileIO();
        Statistics stats = new Statistics();
        Student[] students = new Student[MAX_STUDENTS];
        StudentGrade originalGradeReport = null;

        try {
            // 1. Setup: Load and process data
            students = fileUtility.readFile(DATA_FILE, students);
            stats.findlow(students);
            stats.findhigh(students);
            stats.findavg(students);
            
            // 2. Create the serializable container object
            originalGradeReport = new StudentGrade(students, stats);
            
            // 3. Serialize the object (Save grade report to file)
            fileUtility.serializeGrade(originalGradeReport, SERIALIZED_FILE);

            // 4. Demonstrate Deserialization (Load grade report from file)
            System.out.println("\n--- Deserializing Data for Verification ---");
            StudentGrade deserializedGradeReport = fileUtility.deserializeGrade(SERIALIZED_FILE);
            
            // 5. Print the data from the deserialized object to verify integrity
            if (deserializedGradeReport != null) {
                deserializedGradeReport.printReport();
            }

        } catch (StudentGradingException e) {
            System.err.println("Fatal Error during setup or serialization (Logged): " + e.getErrorMsg());
        }
    }
}