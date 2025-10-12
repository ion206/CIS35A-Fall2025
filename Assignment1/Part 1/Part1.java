/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 1
Due Date: October 12th, 2025
Date Submitted: October 12th, 2025
 */


//Lab 1 Part 1 - Loan Amortization

/* Design

    This Java program first prompts the user for the loan amount, the number of years for repayment, and the annual interest rate. 
    It then calculates the necessary monthly payment and generates a detailed amortization schedule, breaking down each payment into interest and principal until the loan is fully repaid.


    Functions:
    calculateMonthlyPayment - Takes the loan amount (double), monthly interest rate (double), and total payments (int) to return the monthly payment (double).

    calculateTotalPayment - Takes the monthly payment (double) and total payments (int) to return the total payment over the loan's life (double).

    displayLoanSummary - Takes the loan's summary details (5 doubles/ints) and prints the formatted summary to the console (void).

    main - Handles user input, calls the calculation and summary methods, and then uses a loop to print the detailed amortization schedule (void).
    
    As mentioned in the syllabus, all necessary testruns and test cases can be found for this code in testrun1.txt

 */
import java.util.Scanner;
import java.lang.Math;

public class Part1 {

     //Calculates the monthly payment for a loan using the amortization formula.
     //Formula being used -> M = P * [r / (1 - (1 + r)^-n)]
    public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int totalNumberOfPayments) {
        /* 
        * loanAmount (double) The principal loan amount (P).
        * monthlyInterestRate (double) The monthly interest rate (r) as a decimal.
        * totalNumberOfPayment (int) The total number of payments (n).
        * return (double) The calculated monthly payment (M).
        */
        if (monthlyInterestRate == 0) {
            // Handle the zero interest rate case using an if statement - we have a devide by zero after so this reduces error
            //Just return the amount equally decided over the months
            return loanAmount / totalNumberOfPayments;
        }

        double numerator = monthlyInterestRate;
        // Use Math.pow(base, negative_exponent) for deviding and exponent 
        double denominator = 1 - Math.pow(1 + monthlyInterestRate, -totalNumberOfPayments);

        return loanAmount * (numerator / denominator);
    }

     // Calculates the total payment over the life of the loan.
    public static double calculateTotalPayment(double monthlyPayment, int totalNumberOfPayments) {
        /*
        * monthlyPayment (double) The calculated monthly payment.
        * totalNumberOfPayments (int) The total number of payments.
        * return (double) The total amount paid.
        */
        return monthlyPayment * totalNumberOfPayments;
    }

    // Prints a summary of the loan details and key results.
    public static void displayLoanSummary(double loanAmount, int numberOfYears, double annualInterestRate, double monthlyPayment, double totalPayment) {
        
        /* loanAmount (double) The principal loan amount.
        *  numberOfYears (int) The loan term in years.
        *  annualInterestRate (double) The annual interest rate (e.g., 7.0).
        *  monthlyPayment (double) The calculated monthly payment.
        *  totalPayment (double) The calculated total payment.
        *  return (void) None
        */
        System.out.println("\n------------------------------------------------");
        System.out.println("Loan Summary:");
        System.out.printf("Loan Amount: $%.2f\n", loanAmount);
        System.out.println("Number of Years: " + numberOfYears);
        System.out.println("Annual Interest Rate: " + annualInterestRate + "%");
        System.out.printf("\nMonthly Payment: $%.2f\n", monthlyPayment);
        System.out.printf("Total Payment: $%.2f\n", totalPayment);
        System.out.printf("Total Interest Paid: $%.2f\n", totalPayment - loanAmount);
        System.out.println("------------------------------------------------");
    }

    //main method
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // --- 1. Get User Input ---
        System.out.print("Enter Loan Amount: ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter Number of Years: ");
        int numberOfYears = scanner.nextInt();

        System.out.print("Enter Annual Interest Rate (e.g., 7 for 7%): ");
        double annualInterestRate = scanner.nextDouble();

        scanner.close(); //Wont be needing any more user inputs so we can close scanner

        //Calculate Varaibles
        double monthlyInterestRate = annualInterestRate / 100 / 12;
        int totalNumberOfPayments = numberOfYears * 12;

        //Monthly Payment - using a custom function
        double monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, totalNumberOfPayments);

        // Calculating the total Payment - using custom function
        double totalPayment = calculateTotalPayment(monthlyPayment, totalNumberOfPayments);


        // --- Display Summary Results ---
        displayLoanSummary(loanAmount, numberOfYears, annualInterestRate, monthlyPayment, totalPayment);


        // --- Generate Amortization Schedule ---

        System.out.println("\nAmortization Schedule:");
        // Printing header for the table
        System.out.printf("%-10s %-12s %-12s %s\n", "Payment#", "Interest", "Principal", "Balance");
        
        //Variables to be updated and used in loop 
        double balance = loanAmount;
        double monthlyInterest;
        double principalPaid;
        double adjustedMonthlyPayment = monthlyPayment; // To handle the final payment adjustment

        //Runs for the amount of payments needed and calculates how much is remaining at each payment
        for (int i = 1; i <= totalNumberOfPayments; i++) {
            //Calculate Monthly Interest based on the current balance
            monthlyInterest = monthlyInterestRate * balance;

            //Calculate Principal Paid -> subtracting the montly payment amount by the calculated interest amount
            principalPaid = adjustedMonthlyPayment - monthlyInterest;

            if (i == totalNumberOfPayments) { //on the last iteration
                // The principal paid must exactly match the remaining balance to finish out the loan
                principalPaid = balance;
                // Recalculate monthly payment for this specific final month (for accurate display)
                adjustedMonthlyPayment = principalPaid + monthlyInterest; 
            }

            //Update the remaining balance for next iteration
            balance = balance - principalPaid;

            // Using if statemnt to ensure the final balance is not negative due to floating-point arithmetic
            if (balance < 0) {
                balance = 0;
            }

            // Print the current payment row
            System.out.printf("%-10d %-12.2f %-12.2f %.2f\n",
                i,
                monthlyInterest,
                principalPaid,
                balance
            );
        }
    }
}