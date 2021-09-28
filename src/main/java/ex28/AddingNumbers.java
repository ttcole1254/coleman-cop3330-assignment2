package ex28;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;

public class AddingNumbers {
    public static Scanner in = new Scanner(System.in);
    public static double addNumbers(double[] arr) {
        return DoubleStream.of(arr).sum();
    }
    public static boolean isNumber(String in) {
        return Pattern.matches("^\\d+$", in);
    }
    public static double looper(int loops) {
        double[] arr = new double[loops];
        // Manual for loop to control when to move on
        int i = 0;
        while (i < loops){
            System.out.println("Enter a number: ");
            String number = in.next();
            // If the input is a number, move to next iter
            if (isNumber(number)) {
                arr[i] = Double.parseDouble(number);
                i += 1;
            }
            // If the input is not a number, don't change iter num
        }
        return addNumbers(arr);
    }
    public static void main(String[] args) {
        System.out.println("How many numbers do you want to add? ");
        int numToAdd = in.nextInt();
        double total = looper(numToAdd);
        System.out.println("The total is " + total);
    }
}
