/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 4 - Exercise 1, Part 2
Due Date: November 12th, 2025
Date Submitted: November 12th, 2025

SpecialSavings.java

Child Class of SavingsAccount
Extends SavingsAccount and demonstrates polymorphism by overriding the 
interest calculation to pay 10% on balances > $10,000 

static final SPECIAL_RATE -  rate to be applied to acccount with over THRESHOLD
static final THRESHOLD - the threshold for account to be charge the special interest rate on

Contructor calls super constructor
void calculateMonthlyInterest() overrides the SavingsAcccount version and applies threshold and special rate logic
*/
public class SpecialSavings extends SavingsAccount {
    private static final double SPECIAL_RATE = 0.10; // 10%
    private static final double THRESHOLD = 10000.00;

    /**
     * Constructor calls the parent's constructor using super() 
     * double initialBalance - The starting balance of the savings account 
     */
    public SpecialSavings(double initialBalance) {
        super(initialBalance);
    }

    /**
     * Overrides the parent method (Polymorphism) to apply conditional interest 
     * If balance > $10,000, use 10% interest  Otherwise, use the static annualInterestRate 
     */

    public void calculateMonthlyInterest() {
        double applicableRate;

        if (savingsBalance > THRESHOLD) {
            // Apply special 10% rate
            applicableRate = SPECIAL_RATE;
            System.out.printf("  [Special Rate Applied: %.1f%%]\n", SPECIAL_RATE * 100);
        } else {
            // Apply standard static rate inherited from parent
            applicableRate = getAnnualInterestRate(); 
        }

        double monthlyInterest = this.savingsBalance * (applicableRate / 12.0);
        this.savingsBalance += monthlyInterest;
    }
}