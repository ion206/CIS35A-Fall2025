/*
ScoreAnalyzer Driver Class
Orchestrates the program flow: reads data using Util, computes statistics, 
and prints the final tables.
*/
public class ScoreAnalyzer {
    private static final String FILE_NAME = "data.txt";
    private static final int MAX_STUDENTS = 40;

    /**
     * Prints the formatted header for the student data table.
     */
    public static void printDataHeader() {
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-7s%-7s%-7s%-7s%-7s%-7s\n", "Stud", "Q1", "Q2", "Q3", "Q4", "Q5");
        System.out.println("-------------------------------------------------------");
    }

    /**
     * Prints the entire populated student data table.
     * @param students The array of Student objects.
     */
    public static void printStudentData(Student[] students) {
        System.out.println("\n--- Student Quiz Scores (Input Order) ---");
        printDataHeader();
        
        for (Student student : students) {
            if (student != null && student.getSID() != 0) {
                student.print();
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Instantiate the Student array with max capacity
        Student[] lab2 = new Student[MAX_STUDENTS];
        
        // Instantiate Util class
        Util fileUtility = new Util();
        
        // Populate the student array
        // The array is passed by reference and then returned (as per sample usage)
        System.out.println("Attempting to read data from: " + FILE_NAME);
        lab2 = fileUtility.readFile(FILE_NAME, lab2);
        
        // Check if population was successful
        if (lab2.length == 0 || lab2[0] == null) {
            System.out.println("Program terminated due to file reading error.");
            return;
        }

        // Print the data table
        printStudentData(lab2);
        
        // Instantiate Statistics class
        Statistics statlab2 = new Statistics();
        
        // Compute statistics (Object Relationship: Association - Stat class uses Student array)
        statlab2.findlow(lab2);
        statlab2.findhigh(lab2);
        statlab2.findavg(lab2); 

        // Print Statistics
        System.out.println("\n--- Statistical Analysis per Quiz ---");
        printDataHeader();
        
        // Print all statistics (option 4)
        statlab2.print(4);
        System.out.println("-------------------------------------------------------");
    }
}