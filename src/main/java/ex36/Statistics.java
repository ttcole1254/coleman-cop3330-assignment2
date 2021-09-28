package ex36;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Statistics {
    public static double average(ArrayList<Double> numbers) {
        return numbers.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }
    public static double max(ArrayList<Double> numbers) {
        return numbers.stream()
                .mapToDouble(d -> d)
                .max()
                .orElse(0.0);
    }
    public static double min(ArrayList<Double> numbers) {
        return numbers.stream()
                .mapToDouble(d -> d)
                .min()
                .orElse(0.0);
    }
    public static double std(ArrayList<Double> numbers) {
        double recip = 1.0 / numbers.size();
        double sum = 0.0;
        double avg = 0.0;
        for (double number : numbers) {
            avg += number;
        } avg *= recip;
        for (double number : numbers) {
            sum += (number - avg) * (number - avg);
        } sum *= recip;
        return Math.sqrt(sum);
    }
    public static void printOutput(ArrayList<Double> numbers, double avg, double max, double min, double std) {
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
        System.out.print("Numbers: ");
        System.out.print(numbers.stream().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.printf("\nThe average is %s\nThe minimum is %s\nThe maximum is %s\nThe standard deviation is %s", format.format(avg), format.format(min), format.format(max), format.format(std));
    }
    public static void statistics(ArrayList<Double> numbers) {
        double average = average(numbers);
        double max = max(numbers);
        double min = min(numbers);
        double std = std(numbers);
        printOutput(numbers, average, max, min, std);
    }
    public static ArrayList<Double> addToArray(ArrayList<Double> numbers, String input) {
        numbers.add(Double.parseDouble(input));
        return numbers;
    }
    public static boolean isNumber(String in) {return Pattern.matches("^\\d+$", in);}
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String print = "Enter a number: ";
        String nextLine = "";
        System.out.println(print);
        while(!(nextLine = in.nextLine()).equals("done")) {
            System.out.println(print);
            if (isNumber(nextLine)) {
                addToArray(numbers, nextLine);
            }
        }
        statistics(numbers);
    }
}
