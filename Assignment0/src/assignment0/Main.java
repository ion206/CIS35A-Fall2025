package assignment0;

import java.util.Scanner;
import java.io.*; // Access System.out


public class Main {

	double TVCOST = 400.00; //$ - Dollars
	double VCRCOST = 220.00; //$ - Dollars
	double REMOTECOST = 35.20; //$ - Dollars
	double CDPLAYERCOST = 300.00; //$ - Dollars
	double RECORDERCOST = 150.00; //$ - Dollars
	
	double TAXRATE = 8.25; //Percent
	
	public static void main(String[] args) {
		int numTV;
		int numVCR;
		int numRemote;
		int numCD;
		int numRecorder;
		
		Scanner in = new Scanner(System.in);
		
		//TVs
		System.out.printf("Enter the number of TVs? ");
		numTV = in.nextInt();
		
		System.out.println(numTV);
		
		in.close();
				
	}

}
