/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 4 - Exercise 1, Part 1 & 2
Due Date: November 12th, 2025
Date Submitted: November 12th, 2025

Handles the basic savings balance, deposit/withdrawal logic, and a static annual interest rate common to all savers

static annualInterestRate - common interest var between all savers
double savingsBalance - the current balance of the accounts

Has both a default and overridden contructor
Getters and settter for annualInterestRate
Getter for savingsBalance

deposit, withdrawal functions
printBalance prints the current balance and interest rate
*/
public class SavingsAccount {
    // Static class variable (shared by all instances)
    private static double annualInterestRate = 0.00; 

    // Instance variable (unique to each object). Protected for child class access
    protected double savingsBalance;

    /**
     * Constructor to initialize the account balance
     * initialBalance - The starting balance of the savings account
     */
    public SavingsAccount(double initialBalance) {
        this.savingsBalance = initialBalance;
    }

    /**
     * Default constructor - sets balance to 0
     */
    public SavingsAccount() {
        this.savingsBalance = 0.0;
    }

    // --- Accessor Methods (Protected for Child Access) ---

    protected double getSavingsBalance() {
        return savingsBalance;
    }

    protected static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /*
     * Static method to modify the annual interest rate for ALL savers
     * newRate - The new annual interest rate (e.g., 0.04 for 4%)
     */
    public static void modifyInterestRate(double newRate) {
        if (newRate >= 0) {
            annualInterestRate = newRate;
        } else {
            System.out.println("Error: Interest rate cannot be negative.");
        }
    }
    
    // --- Core Logic Methods ---

    /**
     * Calculates the monthly interest and adds it to the savingsBalance 
     * This method is designed for standard interest calculation (Polymorphism Base Method - SpecialSavings overrides this)
     */
    public void calculateMonthlyInterest() {
        // Interest calculation: Balance * (Rate / 12)
        double monthlyInterest = this.savingsBalance * (annualInterestRate / 12.0);
        this.savingsBalance += monthlyInterest;
    }

  
    /**
     * Deposits the specified amount into the account
     * amount (double) -  The amount to deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            this.savingsBalance += amount;
        }
    }

    /**
     * Withdraws the specified amount from the account if funds are sufficient
     * amount (double) - The amount to withdraw
     * return (bool) true if withdrawal was successful, false otherwise
     */
    public boolean withdrawal(double amount) {
        if (amount > 0 && this.savingsBalance >= amount) {
            this.savingsBalance -= amount;
            return true;
        }
        return false;
    }
    
    /*
     * Prints the current account status, (name, balance, interestRate)
     * saverName (String) -  The name/label of the saver for clearer output
     */
    public void printBalance(String saverName) {
        System.out.printf("%s Balance: $%.2f (Rate: %.1f%%)\n", saverName, this.savingsBalance, annualInterestRate * 100);
    }
}