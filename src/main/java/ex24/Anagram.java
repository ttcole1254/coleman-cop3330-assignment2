package ex24;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean isAnagram(String str1, String str2)
    {
        //Remove all whitespace from strings
        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s", "");

        // Get lengths of strings
        int length1 = str1.length();
        int length2 = str2.length();

        // If the lengths are not the same, it's not an anagram
        if (length1 != length2)
            return false;

        // Convert to char to sort the characters of each string
        char[] arrayStr1 = str1.toLowerCase().toCharArray();
        char[] arrayStr2 = str2.toLowerCase().toCharArray();

        // Sort the arrays, if they are anagrams these should be equal.
        Arrays.sort(arrayStr1);
        Arrays.sort(arrayStr2);

        return Arrays.equals(arrayStr1, arrayStr2);
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings and I'll tell you if they are anagrams:");
        System.out.println("Enter the first string: ");
        String str1 = in.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = in.nextLine();
        if (isAnagram(str1, str2))
            System.out.printf("%s and %s are anagrams.", str1, str2);
        else
            System.out.printf("%s and %s are not anagrams.", str1, str2);
    }
}