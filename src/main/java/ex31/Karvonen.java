package ex31;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class Karvonen {
    public static Scanner in = new Scanner(System.in);
    public static void targetHeartRate(int restingPulse, int age) {
        System.out.printf("Intensity \t | Rate\n-------------|--------\n");
        for (int i = 55; i <= 95; i+=5) {
            int targetHR = (((220 - age) - restingPulse) * i/100) + restingPulse;
            System.out.printf("%d%%\t\t\t | %d bpm\n", i, targetHR);
        }
    }
    public static boolean isNumber(String in) {return Pattern.matches("^\\d+$", in);}
    public static int validateInput(String statementIn) {
        String out = null;
        boolean isNumber = false;
        while (!isNumber) {
            System.out.println(statementIn);
            out = in.next();
            if (!isNumber(out)) {
                System.out.println("Sorry. That's not a valid input.");
            }
            else isNumber = true;
        }
        return Integer.parseInt(out);
    }
    public static void main(String[] args) {
        int restingPulse = validateInput("What is the resting pulse?");
        int age = validateInput("What is the age?");
        targetHeartRate(restingPulse, age);
    }
}
