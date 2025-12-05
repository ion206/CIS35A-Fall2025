/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 6
Due Date: December 4th, 2025
Date Submitted: December 4th, 2025


FileIO.java
File Input and Output Manager Class 
Part of util Package

Hosts useful functions for reading Student Files, and serializing/deserializing them


Main Functions:
+ readFile(String, Student) - reads the given data file and returns an array of Students, throws exceptions to be fixed
+ serializeStudentGrade(StudentGrade, String) - given a Student, serializes the data in given filename's File for future reuse
+ deserializeStudentGrade(String) - Extracts StudentGrade Infromation from a given file name and return the data

*/

package util;

import java.io.*;
import java.util.StringTokenizer;
import model.*;
import exception.StudentGradingException;

public class FileIO {

    // Constant for Exception Numbers
    public static final int FILE_NOT_FOUND_ERR = 101;

    //ReadFile to throw custom exception
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
            //Given an error, prints the stack trace for debugging
            i.printStackTrace();
        }
        return sg;
    }
}