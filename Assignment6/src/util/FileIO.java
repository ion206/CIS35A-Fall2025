package util;

import java.io.*;
import java.util.StringTokenizer;
import model.*;
import exception.StudentGradingException;

public class FileIO {

    // Constant for Exception Numbers
    public static final int FILE_NOT_FOUND_ERR = 101;

    // Modified readFile to throw custom exception
    public Student[] readFile(String filename, Student[] stu) throws StudentGradingException {
        int studentIndex = 0;

        try (FileReader file = new FileReader(filename);
             BufferedReader buff = new BufferedReader(file)) {
             
            buff.readLine(); // skip header

            String line;
            while ((line = buff.readLine()) != null && studentIndex < stu.length) {
                stu[studentIndex] = new Student(); 
                StringTokenizer st = new StringTokenizer(line);
                stu[studentIndex].setSID(Integer.parseInt(st.nextToken()));
                for (int i = 0; i < 5; i++) {
                    int score = Integer.parseInt(st.nextToken());
                    stu[studentIndex].setScore(i, score);
                }
                studentIndex++;
            }
        }
        catch (FileNotFoundException e) {
            // Req 1: Throwing Custom Exception
            throw new StudentGradingException(FILE_NOT_FOUND_ERR, "File not found: " + filename);
        }
        catch (IOException e) {
            System.out.println("Error reading file. " + e.getMessage());
        }
        
        return stu; 
    }

    // Req 2: Serialize StudentGrade object
    public void serializeStudentGrade(StudentGrade sg, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(sg);
            System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    // Req 2: Deserialize StudentGrade object (for testing)
    public StudentGrade deserializeStudentGrade(String fileName) {
        StudentGrade sg = null;
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            sg = (StudentGrade) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return sg;
    }
}