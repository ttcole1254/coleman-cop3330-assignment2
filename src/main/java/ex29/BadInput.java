package ex29;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BadInput {
    public static boolean isNumber(String in) {
        return Pattern.matches("^\\d+$", in);
    }
    public static double rateOfReturn(double r) {
        return 72 / r;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean isNumber = false;
        String rateIn = null;
        while (!isNumber) {
            System.out.println("What is the rate of return?");
            rateIn = in.next();
            if (!isNumber(rateIn)) {
                System.out.println("Sorry. That's not a valid input.");
            }
            else if (Objects.equals(rateIn, "0")) {
                System.out.println("You cannot enter a zero, please try again.");
            }
            else isNumber = true;
        }
        int years = (int) Math.round(rateOfReturn(Double.parseDouble(rateIn)));
        System.out.printf("It will take %d years to double your initial investment.", years);
    }
}
