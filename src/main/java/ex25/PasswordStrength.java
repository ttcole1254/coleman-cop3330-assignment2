package ex25;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrength {
    public static boolean validateVeryWeak(String password) {
        // Regex, if string contains only numbers and is fewer than 8 characters
        return Pattern.matches("^[0-9]*$", password) && password.length() < 8;
    }
    public static boolean validateWeak(String password) {
        // Regex, if string contains only letters and is fewer than 8 characters
        return Pattern.matches("^[a-zA-Z]*$", password) && password.length() < 8;
    }
    public static boolean validateStrong(String password) {
        // Regex, if string contains letters and at least one number and is at least 8 characters
        return Pattern.matches("^(?=.*\\d)(?=.*[a-zA-Z])(?!.*[^\\w\\d\\s:])([^\\s]){8,}$", password);
    }
    public static boolean validateVeryStrong(String password) {
        // Regex, if string contains letters, numbers, and special characters and is at least 8 characters
        return Pattern.matches("^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[^\\w_\\d\\s:])([^\\s]){8,}$", password);
    }
    public static int passwordValidator(String password) {
            // Return 1 for Very Weak Password
            // Return 2 for Weak Password
            // Return 3 for Strong Password
            // Return 4 for Very Strong Password
        boolean veryWeakPassword = validateVeryWeak(password);
        boolean weakPassword = validateWeak(password);
        boolean strongPassword = validateStrong(password);
        boolean veryStrongPassword = validateVeryStrong(password);
        if (veryWeakPassword) return 1;
        if (weakPassword) return 2;
        if (strongPassword) return 3;
        if (veryStrongPassword) return 4;
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a password to test: ");
        String password = in.nextLine();
        String passwordStrength = "";
        switch (passwordValidator(password)) {
            case 0 -> {
                System.out.println("Error in determining password strength.");
                passwordStrength = "very error-prone";
            }
            case 1 -> passwordStrength = "very weak";
            case 2 -> passwordStrength = "weak";
            case 3 -> passwordStrength = "strong";
            case 4 -> passwordStrength = "very strong";
        }
        System.out.printf("The password %s is a %s password.", password, passwordStrength);
    }
}
