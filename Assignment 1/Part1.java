/*
Ayan Syed
F25 CIS D035A 11Y, 62Z Java Programming
Assignment -1
Due Date: October 3rd, 2025
Date Submitted: October 3rd, 2025
 */


//Lab -1 Part 1

/* 1. Design
    Prompt user to input the amount desired of items
    List of possibles items: 
    * TVs
    * VCRs
    * Remote Controllers
    * CD Players
    * Tape Recorders
    
    Predefined contstants at the top of main function describe the dollar value of 1x of each item and the tax rate to be charged


    Given the amount desired of each item from the user, this program will produce an itemized receipt of item-cost, item-subtotal, global-subtotal,  applied tax, and global total
    all in a formattted and easy to read description


    Constants:
    * {item}COST - Costs for all available items in dollars (float)
    * TAXRATE - Tax Rate percentage to be charged on subtotal (float)
    
    Variables:
    * num{item} - Variables to store the amount desired of each item (int)
    * subtotal - running subtotal of all costs as they are added up before tax is applied (float)
    
    As mentioned in the syllabus, all necessary testruns and test cases can be found for this code in testrun1.txt

 */

import java.util.Scanner;


public class Part1{
	public static void main(String[] args) {


        //CONSTANTS and units (float)
		final float TVCOST = 400.00f; //$ - Dollars
		final float VCRCOST = 220.00f; //$ - Dollars
		final float REMOTECOST = 35.20f; //$ - Dollars
		final float CDPLAYERCOST = 300.00f; //$ - Dollars
		final float RECORDERCOST = 150.00f; //$ - Dollars
		
		final float TAXRATE = 8.25f; //Percent --> out of 100
		
        //Int Variables will hold the purchase counts of available products being
		int numTV;
		int numVCR;
		int numRemote;
		int numCD;
		int numRecorder;
		

        //Sum of all totals (pretax)
		float subtotal = 0f;
		
		Scanner in = new Scanner(System.in);

        //-----PROMPTING------
        //Gathering purchase counts of each item by prompting the user
		
		//TVs
		System.out.printf("How many TV's were sold? ");
		numTV = in.nextInt();
		
		//VCRs
		System.out.printf("How many VCR's were sold? ");
		numVCR = in.nextInt();

		//Remote Controllers
		System.out.printf("How many remote controller's were sold? ");
		numRemote = in.nextInt();
		
		//CDs
		System.out.printf("How many CD's were sold? ");
		numCD = in.nextInt();
		
		//Tape Recorders
		System.out.printf("How many Tape Recorder's were sold? ");
		numRecorder = in.nextInt();
		
		//------PRINTING OUTPUT-------
        //Provide users with an itemized summary of the costs of each product, subtotal, and final bill


        //Header for the receipt output
        System.out.printf("QTY  %-15s %-12s %s\n", "DESCRIPTION", "UNIT PRICE", "TOTAL PRICE");

        // --- Item Calculations and Display ---
        float TVTotalPrice = TVCOST * numTV;
        subtotal += TVTotalPrice;
        System.out.printf("%3d  %-15s $%10.2f $%10.2f\n", numTV, "TV", TVCOST, TVTotalPrice);
        // Using %.2f for two decimal places (currency) and improved spacing

        // VCRs
        float VCRTotalPrice = VCRCOST * numVCR;
        subtotal += VCRTotalPrice;
        System.out.printf("%3d  %-15s $%10.2f $%10.2f\n", numVCR, "VCR", VCRCOST, VCRTotalPrice);

        // Remote Controllers
        float RemoteTotalPrice = REMOTECOST * numRemote;
        subtotal += RemoteTotalPrice;
        System.out.printf("%3d  %-15s $%10.2f $%10.2f\n", numRemote, "Remote", REMOTECOST, RemoteTotalPrice);

        // CD Players
        float CDTotalPrice = CDPLAYERCOST * numCD;
        subtotal += CDTotalPrice;
        System.out.printf("%3d  %-15s $%10.2f $%10.2f\n", numCD, "CD Player", CDPLAYERCOST, CDTotalPrice);

        // Tape Recorders
        float RecorderTotalPrice = RECORDERCOST * numRecorder;
        subtotal += RecorderTotalPrice;
        System.out.printf("%3d  %-15s $%10.2f $%10.2f\n", numRecorder, "Tape Recorder", RECORDERCOST, RecorderTotalPrice);

        
        float taxAmount = subtotal * (TAXRATE / 100.0f); // Calculate tax amount
        float grandTotal = subtotal + taxAmount;        // Calculate grand total

        //Display final totals and metrics
        System.out.printf("---------------------------------------------\n");
        System.out.printf("%31s %10.2f\n", "SUBTOTAL:", subtotal); //SubTotal
        System.out.printf("%31s %10.2f\n", "TAX:  ", taxAmount); // Display tax rate
        System.out.printf("%31s %10.2f\n", "TOTAL: ", grandTotal); // GrandTotal
        System.out.printf("---------------------------------------------\n");

        in.close(); // Closing Scanner
				
	}

}
