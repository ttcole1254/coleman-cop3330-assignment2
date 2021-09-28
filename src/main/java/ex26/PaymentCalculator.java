package ex26;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.ceil;
import static java.lang.Math.log;

public class PaymentCalculator {
    public static int calculateMonthsUntilPaidOff(double b, double apr, double p) {
        if (apr > 0)
            apr /= 100;
        else {
            System.out.println("APR must be positive and greater than 0.");
            return 0;
        }
        double i = apr / 365;
        double power = Math.pow(1 + i, 30);
        double monthsD = -(1.0 / 30.0) * log(1 + b/p * (1 - power)) / log(1 + i);
        return (int) ceil(monthsD);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("What is your balance? ");
            double balance = in.nextDouble();
            System.out.println("What is the APR on the card (as a percent)? ");
            double apr = in.nextDouble();
            System.out.println("What is the monthly payment you can make? ");
            double monthlyPayment = in.nextDouble();
            int monthsToPayOff = calculateMonthsUntilPaidOff(balance, apr, monthlyPayment);
            System.out.printf("It will take you %d months to pay off this card.", monthsToPayOff);
        } catch (InputMismatchException ie) {
            System.out.println(ie);
        }
    }
}
