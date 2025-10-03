/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment -1
Due Date: October 3rd, 2025
Date Submitted: October 3rd, 2025
 */

//Lab -1 Part 2


/* 1. Design
 First prompt asks users to enter a temperature of their choosing in Centigrade then displays the answer in Fahrenheit.
 Seconds prompt ask the user to enter temperature in Fahrenheit then displays in Centigrade 
 
 Phase 1:
 	Centigrade input to Fahrenheit 
 
 Phase 2:
 	Fahrenheit input to Centigrade
 
 Formulas being used:
 	Phase 1:
	 C -> F: F = 32 + C(180/100)
	 
	Phase 2:
	 F -> C: C = (F - 32) / (180/100)
 
 
 Variables:
 	temperature (float): Holds the user response to a prompt and is used during calculation for first phase and second. 
 	Note: We can use the same variable here because in the second phase, in.nextFloat() overrides the present value in temperature with the new user input 
 
 All testing runs will be in testrun.txt as described in the syllabus
 */

import java.util.Scanner;


public class Proj2{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		float temperature; //Holds the input temperature given by user
		
		//Phase 1 - Centigrade to Fahrenheit
		System.out.printf("Please enter temperature in Centigrade(C): ");
		temperature = in.nextFloat(); //Storing user float input in temperature
		// Print output temperature in Fahrenheit with label
		System.out.printf("Fahrenheit: ");
		System.out.printf("%.2f", (32f + (temperature * (180.0f/100.0f))));
		
		
		
		//Phase 2 - Fahrenheit to Centigrade
		System.out.printf("\nPlease enter temperature in Fahrenheit(F): ");
		temperature = in.nextFloat(); //Storing user float input in temperature
		// Print output temperature in Centigrade with label
		System.out.printf("Centigrade: ");
		System.out.printf("%.2f", ((temperature - 32f) / (180.0f/100.0f)));
				
		in.close(); // Closing Scanner
	}

}
