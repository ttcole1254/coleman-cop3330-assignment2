package ex30;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

public class Multiplication {
    public static void main(String[] args) {
        for (int a = 1; a <= 12; ++a) {
            for (int b = 1; b <= 12; ++b) {
                System.out.printf("%4d", a * b);
            }
            System.out.println();
        }
    }
}
