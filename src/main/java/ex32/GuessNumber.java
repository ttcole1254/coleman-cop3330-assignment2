package ex32;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.util.*;
import java.util.regex.Pattern;

public class GuessNumber {
    public static int guesses = 1;
    public static String errorString = "Sorry. That's not a valid input.";
    public static Scanner in = new Scanner(System.in);
    public static void game() {
        System.out.println("Let's play Guess the Number!");
        int difficultyLevel = validateInput("Enter the difficulty level (1, 2, or 3): ", true);
        int randomNumber = randomGenerator(difficultyLevel);
        List<Integer> guessesList = new ArrayList<>();
        int guess = validateInput("I have my number. What's your guess? ", false);
        while (guess != randomNumber) {
            if (guessesList.contains(guess)) {
                guesses += 1;
                guess = validateInput("You already guessed that number! Guess again: ", false);
            }
            if (guess > randomNumber) {
                guessesList.add(guess);
                guesses += 1;
                guess = validateInput("Too high. Guess again: ", false);
            }
            if (guess < randomNumber) {
                guessesList.add(guess);
                guesses += 1;
                guess = validateInput("Too low. Guess again: ", false);
            }
            if (guess == randomNumber) {
                if (guesses == 1){System.out.println("You're a mind reader!");}
                if (guesses >= 2 && guesses <= 4){System.out.println("Most impressive!");}
                if (guesses >= 5 && guesses <= 6){System.out.println("You can do better than that.");}
                if (guesses >= 7){System.out.println("Better luck next time.");}
                System.out.printf("You got it in %d guesses!", guesses);
                if (validateYN("\nDo you wish to play again (Y/N)? ").equals("y")) {
                    guesses = 1;
                    guessesList.clear();
                    game();
                }
            }
        }
    }
    public static int randomGenerator(int difficultyLevel) {
        int randomNumber;
        switch (difficultyLevel) {
            case 1 -> randomNumber = (int) Math.floor(Math.random()*(10-1+1)+1);
            case 2 -> randomNumber = (int) Math.floor(Math.random()*(100-1+1)+1);
            case 3 -> randomNumber = (int) Math.floor(Math.random()*(1000-1+1)+1);
            default -> throw new IllegalStateException("Unexpected value: " + difficultyLevel);
        }
        return randomNumber;
    }
    public static boolean isNumber(String in) {return Pattern.matches("^\\d+$", in);}
    public static int validateInput(String statementIn, boolean difficultyLevel) {
        String out = null;
        boolean isNumber = false;
        while (!isNumber) {
            System.out.println(statementIn);
            out = in.next();
            if (difficultyLevel) {
                if (Objects.equals(out, "1") | Objects.equals(out, "2") | Objects.equals(out, "3")) {
                    isNumber = true;
                } else {System.out.println(errorString);}
            }
            else if (!isNumber(out)) {
                guesses += 1;
                System.out.println(errorString);
            }
            else isNumber = true;
        }
        return Integer.parseInt(out);
    }
    public static String validateYN(String statementIn){
        String out = null;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(statementIn);
            out = in.next().toLowerCase();
            if (out.equals("y") | (out.equals("n"))) {
                isValid = true;
            } else {
                System.out.println(errorString);
            }
        }
        return out;
    }
    public static void main(String[] args) {
        game();
    }
}
