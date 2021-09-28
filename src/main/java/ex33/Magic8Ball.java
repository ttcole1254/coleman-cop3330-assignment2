package ex33;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.Scanner;

public class Magic8Ball {
    public static int randomGenerator(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] choices = {"Yes", "No", "Maybe", "Ask again later."};
        System.out.println("What's your question? ");
        in.nextLine();
        System.out.println(choices[randomGenerator(0, 3)]);
    }
}
