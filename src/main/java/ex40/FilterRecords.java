package ex40;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.*;
import java.util.regex.Pattern;

class EmployeeR {
    String firstName;
    String lastName;
    String position;
    String separationDate;
    public EmployeeR(String firstName, String lastName, String position, String separationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.separationDate = separationDate;
    }
    String getFirstName() {
        return firstName;
    }
    String getPosition() {
        return position;
    }
    String getSeparationDate() {
        return separationDate;
    }
}
public class FilterRecords {
    public static void printEmpl(TreeMap<String, EmployeeR> employees, String searchTerm) {
        System.out.println("Name                 | Position             | Separation Date");
        System.out.println("---------------------|----------------------|----------------");
        String fullName = "";
        for (Map.Entry<String, EmployeeR> entry : employees.entrySet()) {
            fullName = entry.getValue().getFirstName() + " " + entry.getKey();
            if (fullName.toLowerCase().contains(searchTerm.toLowerCase()))
                System.out.printf("%-20s | %-20s | %-20s\n", fullName, entry.getValue().getPosition(), entry.getValue().getSeparationDate());
        }
    }
    public static boolean isString(String in) {return Pattern.matches("^[a-zA-Z]+$", in);}
    public static String validateInput(String statementIn) {
        Scanner in = new Scanner(System.in);
        String out = null;
        boolean isString = false;
        while (!isString) {
            System.out.println(statementIn);
            out = in.next();
            if (!isString(out)) {
                System.out.println("Sorry. That's not a valid input.");
            }
            else isString = true;
        }
        return out;
    }
    public static void main(String[] args) {
        String[] lastNames = {"Johnson", "Xiong", "Michaelson", "Jacobson", "Jackson", "Webber"};
        TreeMap<String, EmployeeR> employees = new TreeMap<>();
        employees.put(lastNames[0], new EmployeeR("John", lastNames[0], "Manager", "2016-12-31"));
        employees.put(lastNames[1], new EmployeeR("Tou", lastNames[1], "Software Engineer", "2016-10-05"));
        employees.put(lastNames[2], new EmployeeR("Michaela", lastNames[2], "District Manager", "2015-12-19"));
        employees.put(lastNames[3], new EmployeeR("Jake", lastNames[3], "Programmer", ""));
        employees.put(lastNames[4], new EmployeeR("Jacquelyn", lastNames[4], "DBA", ""));
        employees.put(lastNames[5], new EmployeeR("Sally", lastNames[5], "Web Developer", "2015-12-18"));
        String searchTerm = validateInput("Enter a search string: ");
        printEmpl(employees, searchTerm);
    }
}
