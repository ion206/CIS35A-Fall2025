package adapter;

import util.StudentGrade;
import Student;

/**
 * StudentAPIImpl Class
 * Implements the StudentAPI interface using tahe StudentGrade/Statistics classes (Adapter pattern).
 */
public class StudentAPIImpl implements StudentAPI {
    
    private StudentGrade gradeReport;

    /**
     * Constructor accepts the populated StudentGrade object.
     */
    public StudentAPIImpl(StudentGrade gradeReport) {
        this.gradeReport = gradeReport;
    }

    /**
     * Implements the interface method to print all statistics (Req 3.1).
     */
    @Override
    public void printStudentStatistics() {
        System.out.println("\n--- API Call: Student Statistics ---");
        // Reuse Statistics class print method
        gradeReport.getStatistics().print(4); 
    }

    /**
     * Implements the interface method to print scores for a given student (Req 3.2).
     */
    @Override
    public void printScoreForStudent(int SID) {
        Student foundStudent = null;
        
        // Search for the student
        for (Student student : gradeReport.getStudents()) {
            if (student != null && student.getSID() == SID) {
                foundStudent = student;
                break;
            }
        }
        
        System.out.println("\n--- API Call: Score for Student ID " + SID + " ---");

        if (foundStudent != null) {
            System.out.println("---------------------------------------------");
            System.out.printf("%-7s%-7s%-7s%-7s%-7s%-7s\n", "Stud", "Q1", "Q2", "Q3", "Q4", "Q5");
            System.out.println("---------------------------------------------");
            foundStudent.print();
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("Error: Student ID " + SID + " not found in the records.");
        }
    }
}