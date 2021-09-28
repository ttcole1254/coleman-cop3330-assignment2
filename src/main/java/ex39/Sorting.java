package ex39;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.*;

class Employee {
    String firstName;
    String lastName;
    String position;
    String separationDate;
    public Employee(String firstName, String lastName, String position, String separationDate) {
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
public class Sorting {
    public static void printEmpl(TreeMap<String, Employee> employees) {
        System.out.println("Name                 | Position             | Separation Date");
        System.out.println("---------------------|----------------------|----------------");
        String fullName = "";
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            fullName = entry.getValue().getFirstName() + " " + entry.getKey();
            System.out.printf("%-20s | %-20s | %-20s\n", fullName, entry.getValue().getPosition(), entry.getValue().getSeparationDate());
        }
    }
    public static void main(String[] args) {
        String[] lastNames = {"Johnson", "Xiong", "Michaelson", "Jacobson", "Jackson", "Webber"};
        TreeMap<String, Employee> employees = new TreeMap<>();
        employees.put(lastNames[0], new Employee("John", lastNames[0], "Manager", "2016-12-31"));
        employees.put(lastNames[1], new Employee("Tou", lastNames[1], "Software Engineer", "2016-10-05"));
        employees.put(lastNames[2], new Employee("Michaela", lastNames[2], "District Manager", "2015-12-19"));
        employees.put(lastNames[3], new Employee("Jake", lastNames[3], "Programmer", ""));
        employees.put(lastNames[4], new Employee("Jacquelyn", lastNames[4], "DBA", ""));
        employees.put(lastNames[5], new Employee("Sally", lastNames[5], "Web Developer", "2015-12-18"));
        printEmpl(employees);
    }
}
