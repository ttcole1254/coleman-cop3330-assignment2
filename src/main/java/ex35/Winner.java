package ex35;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Winner {
    public static int randomGenerator(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
    public static void pickAWinner(ArrayList<String> names) {
        System.out.printf("The winner is... %s", names.get(randomGenerator(0, names.size()-1)));
    }
    public static void askNames() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        String print = "Enter a name: ";
        String nextLine = "";
        System.out.println(print);
        while(!(nextLine = in.nextLine()).isEmpty()) {
            System.out.println(print);
            names.add(nextLine);
        }
        if (!names.isEmpty()) {
            pickAWinner(names);
        }
        else {
            System.out.println("You really expect me to pick a winner if no one's in the list?\nTry again please!");
            askNames();
        }
    }
    public static void main(String[] args) {
        askNames();
    }
}
