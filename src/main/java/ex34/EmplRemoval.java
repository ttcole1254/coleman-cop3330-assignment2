package ex34;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EmplRemoval {
    public static ArrayList<String> empl = new ArrayList<>();
    public static void removeEmpl() {
        Scanner in = new Scanner(System.in);
        boolean emplInArray = false;
        while (!emplInArray) {
            System.out.println("\nEnter an employee to remove: ");
            String emplToRemove = in.nextLine();
            if (empl.contains(emplToRemove)){
                empl.remove(emplToRemove);
                emplInArray = true;
            }
            else {
                System.out.println("There is no employee by that name.");
            }
        }
        printEmpl();
    }
    public static void printEmpl() {
        System.out.printf("There are %d employees: \n", empl.size());
        empl.forEach(System.out::println);
    }
    public static void main(String[] args) {
        empl.add("John Smith");
        empl.add("Jackie Jackson");
        empl.add("Chris Jones");
        empl.add("Amanda Cullen");
        empl.add("Jeremy Goodwin");
        printEmpl();
        removeEmpl();
    }
}
