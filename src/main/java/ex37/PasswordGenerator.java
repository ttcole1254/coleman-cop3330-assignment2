package ex37;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class PasswordGenerator {
    public static Scanner in = new Scanner(System.in);
    public static String generatePassword(int minLength, int numSpecialChars, int numNumbers) {
        int numLetters = numSpecialChars + numNumbers;
        StringBuilder password = new StringBuilder();
        List<String> letters = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
        List<String> specialChars = Arrays.asList("!","\"","#","$","%","&","'","(",")","*","+","-",",",".","/",":",";","<",">","?","@","[","]","\\","^","_","`","{","}","~");
        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        for (int i = 1; i <= numSpecialChars; i++) {
            password.append(specialChars.get(randomGenerator(0, specialChars.size() - 1)));
        }
        for (int i = 1; i <= numNumbers; i++) {
            password.append(numbers.get(randomGenerator(0, numbers.size() - 1)));
        }
        for (int i = 1; i <= numLetters; i++) {
            password.append(letters.get(randomGenerator(0, letters.size() - 1)));
        }
        int passLength = password.length();
        if (!(passLength >= minLength)){
            int numNeeded = minLength - passLength;
            for (int i = 1; i <= numNeeded; i++) {
                password.append(letters.get(randomGenerator(0, letters.size() - 1)));
            }
        }
        String passString = password.toString();
        return shuffle(passString);
    }
    public static String shuffle(String input){
        List<Character> characters = new ArrayList<>();
        for(char c:input.toCharArray()){
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while(characters.size()!=0){
            int randPicker = (int)(Math.random()*characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }
    public static int randomGenerator(int min, int max) {
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }
    public static boolean isNumber(String in) {return Pattern.matches("^\\d+$", in);}
    public static int validateInput(String statementIn) {
        String errorString = "Invalid input, please try again.";
        String out = null;
        boolean isNumber = false;
        while (!isNumber) {
            System.out.println(statementIn);
            out = in.next();
            if (!isNumber(out)) {
                System.out.println(errorString);
            }
            else isNumber = true;
        }
        return Integer.parseInt(out);
    }
    public static void main(String[] args) {
        int minLength = validateInput("What's the minimum length?");
        int numSpecialChars = validateInput("How many special characters?");
        int numNumbers = validateInput("How many numbers?");
        String password = generatePassword(minLength, numSpecialChars, numNumbers);
        System.out.printf("Your password is %s", password);
    }
}