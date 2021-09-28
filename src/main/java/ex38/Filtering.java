package ex38;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Filtering {
    public static Scanner in = new Scanner(System.in);
    public static Integer[] filterEvenNumbers(int[] nums) {
        List<Integer> numsSorted = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                numsSorted.add(nums[i]);
            }
        }
        Integer[] numsSortedArr = new Integer[numsSorted.size()];
        numsSortedArr = numsSorted.toArray(numsSortedArr);
        return numsSortedArr;
    }
    public static boolean isNumber(String in) {return Pattern.matches("^\\d(?: \\d)*$", in);}
    public static String validateInput(String statementIn) {
        String errorString = "Invalid input, please try again.";
        String out = null;
        boolean isNumber = false;
        while (!isNumber) {
            System.out.println(statementIn);
            out = in.nextLine();
            if (!isNumber(out)) {
                System.out.println(errorString);
            }
            else isNumber = true;
        }
        return out;
    }
    public static void main(String[] args) {
        String[] numsStr =  validateInput("Enter a list of numbers, separated by spaces: ").split(" ");
        int[] nums = new int[numsStr.length];
        for(int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }
        Integer[] resultArr = filterEvenNumbers(nums);
        String result = Arrays.stream(resultArr)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.printf("The even numbers are %s.", result);
    }
}
