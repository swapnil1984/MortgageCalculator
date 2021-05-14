package com.swapnil.mortgagecalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculatorApp {

	public static void main(String[] args) {
		// Initialize Variables, constants and objects
        int principle;
        float annualInterest;
        int period;
        double intermediateValue;
        double result;

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);
        NumberFormat currencyResult = NumberFormat.getCurrencyInstance();

        // System Inputs

        while(true) {
            System.out.print("Principle ($1K - $1M): ");
            principle = scanner.nextInt();

            if (principle < 1_000 || principle > 1_000_000) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
                continue;
            }

            while(true) {
                System.out.print("Annual Interest: ");
                annualInterest = scanner.nextFloat();

                if (annualInterest <= 0 || annualInterest > 30) {
                    System.out.println("Enter a value greater than 0 and less than or equal to 30.");
                    continue;
                }

                annualInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

                while(true) {
                    System.out.print("Period (Years): ");
                    period = scanner.nextByte();

                    if (period < 1 || period > 30) {
                        System.out.println("Enter a value between 1 and 30.");
                        continue;
                    }

                    period = period * MONTHS_IN_YEAR;
                    break;
                }
                break;
            }

            // Mortgage calculations

            intermediateValue = Math.pow((1 + annualInterest), period);

            result = principle *
                    ((annualInterest * intermediateValue) / (intermediateValue - 1));

            // Output

            System.out.println("Mortgage: " + currencyResult.format(result));
            break;
        }
        scanner.close();
	}

}
