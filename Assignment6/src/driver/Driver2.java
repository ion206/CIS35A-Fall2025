package driver;

import util.FileIO;
import model.*;

public class Driver2 {
    public static void main(String[] args) {
        System.out.println("--- Driver 2: Serialization ---");

        // 1. Setup data
        Student student = new Student();
        student.setSID(1234);
        int[] scores = {90, 85, 88, 92, 95};
        student.setScores(scores);

        Statistics stats = new Statistics();
        // (Empty stats for demo, or you can populate them)

        // Create the Grade object
        StudentGrade grade = new StudentGrade(student, stats);
        
        // 2. Serialize
        FileIO io = new FileIO();
        String filename = "student_grade.ser";
        io.serializeStudentGrade(grade, filename);
        
        // 3. Deserialize to prove it worked
        System.out.println("\nReading back serialized object...");
        StudentGrade loadedGrade = io.deserializeStudentGrade(filename);
        
        if (loadedGrade != null) {
            System.out.println("Deserialized successfully:");
            loadedGrade.getStudent().print();
        }
    }
}