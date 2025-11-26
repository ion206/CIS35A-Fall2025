package adapter;

import model.*;
import util.FileIO;
import exception.StudentGradingException;

public class StudentAPIImpl implements StudentAPI {
    private Student[] students;
    private Statistics stats;

    // Constructor loads the data to be ready for API calls
    public StudentAPIImpl() {
        this.students = new Student[40]; // Assumption of max students
        this.stats = new Statistics();
        FileIO fileIO = new FileIO();
        
        try {
            // Loading data normally
            fileIO.readFile("StudentData.txt", students);
            
            // Calculate stats immediately
            stats.findlow(students);
            stats.findhigh(students);
            stats.findavg(students);
            
        } catch (StudentGradingException e) {
            System.out.println("API Initialization Error: " + e.getMessage());
        }
    }

    @Override
    public void printStatistics() {
        System.out.println("--- API: Class Statistics ---");
        stats.print(4); // Print All (Low, High, Avg)
    }

    @Override
    public void printScore(int studentId) {
        System.out.println("--- API: Score Search for ID " + studentId + " ---");
        boolean found = false;
        for(Student s : students) {
            if(s != null && s.getSID() == studentId) {
                s.print();
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
}