/*
* CreditCardPayOff.java
* Author: Nathan Everritt
*
* Purpose: 
* This program prompts the user to enter the principal
* amount of money owed on their credit card, Annual Interest Rate, 
* and their Monthly Payment. It then calculates months needed to pay
* off credit card debt. Then, it calculates total amount paid over the 
* amount of months, and the interest paid. Lastly, it calculates overpayment
* to the credit card company, and all values are output on the screen.
* This project's purpose was to show knowledge of variables, type casting,
* input and output statements, and algorithm design.
*/

import java.util.Scanner;
	//imports Scanner use
public class CreditCardPayOff {

	public static void main(String[] args) {
		
		Scanner newScanner = new Scanner(System.in);
			//newScanner will now read values from the input
		
		double principal, annualRate, monthlyPay, monthlyPayLog, debtFormulaTop, debtFormulaBottom, monthsNeededRaw, monthsNeededCeil, totAmount, totInterest, overpayment;
		int monthsNeededInt;
			//seperated the "Months Needed To Pay" equation into two variables, debtFormulaTop, and debtFormulaBottom
			//also seperated "Months Needed to Pay" into 3 variables, Raw, Ceil, and Int, to make it more organized.
		
		System.out.println("Enter principal amount of money owed: ");
			principal = newScanner.nextDouble();
			//prompts user to enter principal
		System.out.println("Enter Annual Interest Rate: ");
		annualRate = newScanner.nextDouble();
			//prompts user to enter Annual Interest Rate
		System.out.println("Enter your Monthly Payment: ");
		monthlyPay = newScanner.nextDouble();
			//prompts user to enter Monthly Payment
		
		
		//below is the Months Needed to Pay Off equation, seperated into parts
		monthlyPayLog = Math.log(monthlyPay);
			// ln(monthlyPayment)
		debtFormulaTop = Math.log(monthlyPay - (annualRate/1200.0)*principal);
			// ln(monthly payment - (annualInterestRate/1200.00) x principal)
		debtFormulaBottom = Math.log((annualRate/1200.0) + 1.0);
			// (bottom of equation): ln((annualInterestRate/1200.0) + 1.0)
		monthsNeededRaw = ((monthlyPayLog - debtFormulaTop)/debtFormulaBottom);
			// (Top of equation) / (Bottom of equation)
		
		
		monthsNeededCeil = Math.ceil(monthsNeededRaw);
			// Rounding up the months needed to pay off
		monthsNeededInt = (int)monthsNeededCeil;
			// Making an int value of monthsNeededCeil to be read on the screen
		
		
		totAmount = (monthsNeededCeil * monthlyPay);
			// Months Needed to Pay Off (Ceil) x Monthly Pay
		totInterest = totAmount - principal;
			// Total Amount Paid - Principal
		
			
		//below is the equation for overpayment	
		//overpayment =    (Monthly Payment x Months Needed To Pay Off (Ceil))	
		//              -  (Monthly Payment x Months Needed to Pay Off (Raw))	
		overpayment = (monthlyPay * monthsNeededCeil) - (monthlyPay * monthsNeededRaw);
		
		
		System.out.printf("Principal: \t\t\t%6.2f\n" , principal);
			// used printf to have 2 decimal places
		System.out.println("Annual Interest Rate (%): \t" + annualRate);
		System.out.println("Monthly Payment: \t\t" + monthlyPay);
		System.out.println();
			// empty line
		System.out.println("Months Needed To Pay Off: \t" + monthsNeededInt);
		System.out.printf("Total Amount Paid: \t\t$%6.2f\n" , totAmount);
		System.out.printf("Total Interest Paid: \t\t$%6.2f\n" , totInterest);
		System.out.printf("Overpayment: \t\t\t$%4.2f\n" , overpayment);
			//all the lines are printed on the screen, used printf again to have 2 decimal places.
	}

}
