/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment 4 - Exercise 1, Driver Program

Driver.java
Driver to test SavingsAccount and SpecialSavings classes
static void main - contains test cases for SavingsAccount and Polymorphsm tests on SpecialSavings

find the output in testruns.txt
*/
public class Driver {
    public static void main(String[] args) {
        
        // ====================================================================
        // PART 1: Standard SavingsAccount Test (Static Variable & Method)
        // ====================================================================
        
        System.out.println("--- Exercise 1, Part 1: Standard Savings Account Test ---");
        
        // Instantiate two SavingsAccount objects
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        
        System.out.println("\nInitial Balances:");
        saver1.printBalance("Saver 1");
        saver2.printBalance("Saver 2");
        
        // Month 1: Set annualInterestRate to 4% (0.04) and calculate
        SavingsAccount.modifyInterestRate(0.04);
        System.out.println("\n--- Month 1: Interest Rate set to 4.0% ---");
        
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        
        saver1.printBalance("Saver 1");
        saver2.printBalance("Saver 2");
        
        // Month 2: Set annualInterestRate to 5% (0.05) and calculate
        SavingsAccount.modifyInterestRate(0.05);
        System.out.println("\n--- Month 2: Interest Rate set to 5.0% ---");
        
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        
        saver1.printBalance("Saver 1");
        saver2.printBalance("Saver 2");

        // ====================================================================
        // PART 2: SpecialSavings Test (Inheritance & Polymorphism)
        // ====================================================================
        
        System.out.println("\n\n--- Exercise 1, Part 2: Special Savings Account Test ---");
        
        // Instantiate two SpecialSavings objects
        SavingsAccount specialSaver1 = new SpecialSavings(9500.00); // Near threshold
        SavingsAccount specialSaver2 = new SpecialSavings(12000.00); // Above threshold
        
        // Reset standard rate (used if balance is below $10K)
        SavingsAccount.modifyInterestRate(0.04); 
        
        System.out.println("\nInitial Balances (Standard Rate 4.0%):");
        specialSaver1.printBalance("Special Saver 1");
        specialSaver2.printBalance("Special Saver 2");
        
        System.out.println("\n--- Month 3: Test Initial Interest Calculation ---");
        
        // Special Saver 1 (9500) uses 4%
        // Special Saver 2 (12000) uses 10% (Polymorphism)
        specialSaver1.calculateMonthlyInterest(); 
        specialSaver2.calculateMonthlyInterest();
        
        specialSaver1.printBalance("Special Saver 1");
        specialSaver2.printBalance("Special Saver 2");
        
        // Make deposits and withdrawals
        System.out.println("\n--- Account Activity ---");
        System.out.println("Special Saver 1 deposits $1000.00 (Crosses threshold)");
        specialSaver1.deposit(1000.00); // New balance: 10531.67
        
        System.out.println("Special Saver 2 withdraws $3000.00 (Drops below threshold)");
        specialSaver2.withdrawal(3000.00); // New balance: 9000.00 range

        System.out.println("\nBalances Before Next Interest Calculation:");
        specialSaver1.printBalance("Special Saver 1");
        specialSaver2.printBalance("Special Saver 2");

        System.out.println("\n--- Month 4: Test Polymorphism After Activity ---");
        
        // Special Saver 1 (10531.67) now uses 10%
        // Special Saver 2 (~9000) now uses 4%
        
        specialSaver1.calculateMonthlyInterest();
        specialSaver2.calculateMonthlyInterest();

        System.out.println("\nFinal Balances:");
        specialSaver1.printBalance("Special Saver 1");
        specialSaver2.printBalance("Special Saver 2");
    }
}