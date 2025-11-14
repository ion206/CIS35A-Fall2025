import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
Util Class
Manages File I/O operations, specifically reading student data from a text file
and populating the array of Student objects.
*/
public class Util {

    /**
     * Reads the student data from a text file, tokenizes the lines,
     * and populates the Student array.
     * * @param filename The name of the input text file.
     * @param stu The Student array to be populated (must be large enough).
     * @return The populated Student array.
     */
    public Student[] readFile(String filename, Student[] stu) {
        int studentIndex = 0;

        // Using try-with-resources for automatic closing of I/O streams
        try (FileReader file = new FileReader(filename);
             BufferedReader buff = new BufferedReader(file)) {
             
            // 1. Skip the header line ("Stud Qu1 Qu2 Qu3 Qu4 Qu5")
            buff.readLine(); 

            String line;
            // 2. Read data line by line until EOF
            while ((line = buff.readLine()) != null && studentIndex < stu.length) {
                // Initialize a new Student object for the array slot
                stu[studentIndex] = new Student(); 
                
                // Tokenize the line
                StringTokenizer st = new StringTokenizer(line);
                
                // 3. Process tokens (SID and 5 scores)
                
                // Read SID (Token 1)
                if (st.hasMoreTokens()) {
                    // Use Integer Wrapper Class: Integer.parseInt(String)
                    stu[studentIndex].setSID(Integer.parseInt(st.nextToken()));
                }
                
                // Read 5 Scores (Tokens 2 through 6)
                for (int i = 0; i < 5; i++) {
                    if (st.hasMoreTokens()) {
                        // Use Integer Wrapper Class: Integer.parseInt(String)
                        int score = Integer.parseInt(st.nextToken());
                        stu[studentIndex].setScore(i, score);
                    } else {
                        System.err.println("Error: Missing score(s) for student ID: " + stu[studentIndex].getSID());
                        break; // Stop processing scores for this line
                    }
                }
                studentIndex++;
            }

        } catch (IOException e) {
            System.out.println("Error reading file '" + filename + "'. Ensure it exists in the correct directory.");
            System.out.println("Details: " + e.getMessage());
            // Return empty or partially filled array on error
            return new Student[0]; 
        }
        
        // Return the array reference (now populated)
        return stu; 
    }
}