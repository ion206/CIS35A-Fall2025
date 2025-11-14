package util;

import java.io.Serializable;

/**
 * StudentGrade Class - Container for serialization (Req 2).
 * Contains the array of students and the calculated statistics.
 */
public class StudentGrade implements Serializable {
    private static final long serialVersionUID = 1L;
    private Student[] students;
    private Statistics statistics;

    public StudentGrade(Student[] students, Statistics statistics) {
        this.students = students;
        this.statistics = statistics;
    }

    // --- Accessors (used by Driver 3 / API) ---
    public Student[] getStudents() { return students; }
    public Statistics getStatistics() { return statistics; }

    /**
     * Prints the student data and statistics in a formatted report.
     */
    public void printReport() {
        System.out.println("\n--- FINAL GRADE REPORT (Deserialized Data) ---");
        
        System.out.println("\n--- Student Quiz Scores ---");
        printDataHeader();
        for (Student student : students) {
            if (student != null && student.getSID() != 0) {
                student.print();
            }
        }
        System.out.println("-------------------------------------------------------");
        
        System.out.println("\n--- Statistical Analysis per Quiz ---");
        printDataHeader();
        statistics.print(4); // Print all stats
        System.out.println("-------------------------------------------------------");
    }

    private void printDataHeader() {
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-7s%-7s%-7s%-7s%-7s%-7s\n", "Stud", "Q1", "Q2", "Q3", "Q4", "Q5");
        System.out.println("-------------------------------------------------------");
    }
}