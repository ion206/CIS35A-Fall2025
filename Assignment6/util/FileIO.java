package util;

import java.io.*;
import java.util.StringTokenizer;

import exception.StudentGradingException;

/**
 * FileIO Class (moved from Util)
 * Handles file reading (text) and object serialization/deserialization (binary).
 */
public class FileIO {
    
    /**
     * Reads student data from a text file, handles errors, and populates the Student array.
     * Throws StudentGradingException on I/O or data errors (Req 1).
     */
    public Student[] readFile(String filename, Student[] stu) throws StudentGradingException {
        int studentIndex = 0;
        
        try (FileReader file = new FileReader(filename);
             BufferedReader buff = new BufferedReader(file)) {
             
            buff.readLine(); // Skip header line
            String line;

            while ((line = buff.readLine()) != null) {
                if (studentIndex >= stu.length) {
                    throw new StudentGradingException(101, "Array capacity exceeded (Max 40 students).");
                }
                
                stu[studentIndex] = new Student(); 
                StringTokenizer st = new StringTokenizer(line);
                
                if (!st.hasMoreTokens()) continue;

                // Read SID (Token 1)
                int sid = Integer.parseInt(st.nextToken());
                stu[studentIndex].setSID(sid);
                
                // Read 5 Scores (Tokens 2 through 6)
                for (int i = 0; i < 5; i++) {
                    if (st.hasMoreTokens()) {
                        int score = Integer.parseInt(st.nextToken());
                        
                        // Check for fixable exception: score out of range (0-100)
                        if (score < 0 || score > 100) {
                            // Throw exception to be handled/logged/fixed by caller
                            throw new StudentGradingException(201, 
                                "Invalid Score (" + score + ") for SID " + sid + " at Quiz " + (i + 1));
                        }
                        
                        stu[studentIndex].setScore(i, score);
                    } else {
                        throw new StudentGradingException(301, 
                            "Missing score(s) detected for SID " + sid + " (Expected 5 scores).");
                    }
                }
                studentIndex++;
            }

        } catch (FileNotFoundException e) {
            throw new StudentGradingException(401, "File not found: " + filename);
        } catch (IOException e) {
            throw new StudentGradingException(501, "General I/O Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new StudentGradingException(601, "Data format error: SID or score is not an integer.");
        }
        
        return stu; 
    }

    /**
     * Serializes a StudentGrade object to a file (Req 2).
     */
    public void serializeGrade(StudentGrade grade, String filename) throws StudentGradingException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            
            out.writeObject(grade);
            System.out.println("[Serialization]: StudentGrade object serialized to '" + filename + "'");
            
        } catch (IOException e) {
            throw new StudentGradingException(701, "Error during serialization: " + e.getMessage());
        }
    }

    /**
     * Deserializes a StudentGrade object from a file (Req 2 support).
     */
    public StudentGrade deserializeGrade(String filename) throws StudentGradingException {
        StudentGrade grade = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
             
            grade = (StudentGrade) in.readObject();
            System.out.println("[Deserialization]: StudentGrade object read from '" + filename + "'");
            
        } catch (FileNotFoundException e) {
            throw new StudentGradingException(402, "Serialized file not found: " + filename);
        } catch (IOException e) {
            throw new StudentGradingException(702, "Error during deserialization I/O: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new StudentGradingException(801, "Class not found during deserialization: " + e.getMessage());
        }
        return grade;
    }
}