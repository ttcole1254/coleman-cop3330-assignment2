package ex27;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static boolean checkIfNotEmpty(String input) {
        return input.length() != 0;
    }
    public static boolean checkIf2Char(String input) {
        return input.length() >= 2;
    }
    public static boolean checkIDFormat(String input) {
        return Pattern.matches("^(?:[a-zA-Z]{2}-)[0-9]{4}$", input);
    }
    public static boolean checkIfNumber(String input) {
        return Pattern.matches("\\b\\d{5}\\b", input);
    }
    public static String validateInput(String firstName, String lastName, String zipCode, String emplID) {
        String returnStatement = "";
        if (!checkIfNotEmpty(firstName)) returnStatement += "The first name must be filled in.\n";
        if (!checkIfNotEmpty(lastName)) returnStatement += "The last name must be filled in.\n";
        if (!checkIf2Char(firstName)) returnStatement += "The first name must be at least 2 characters long.\n";
        if (!checkIf2Char(lastName)) returnStatement += "The last name must be at least 2 characters long.\n";
        if (!checkIDFormat(emplID)) returnStatement += "The employee ID must be in the format of AA-1234.\n";
        if (!checkIfNumber(zipCode)) returnStatement += "The zip code must be a 5 digit number.\n";
        if (returnStatement.isEmpty()) returnStatement += "There were no errors found.";
        return returnStatement;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first name: ");
        String firstName = in.next();
        System.out.println("Enter the last name: ");
        String lastName = in.next();
        System.out.println("Enter the ZIP code: ");
        String zipCode = in.next();
        System.out.println("Enter the employee ID: ");
        String emplID = in.next();
        System.out.println(validateInput(firstName, lastName, zipCode, emplID));
    }
}
