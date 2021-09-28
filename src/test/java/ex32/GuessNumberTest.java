package ex32;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessNumberTest {

    @Test
    void randomGenerator() {
        int rand;
        int min = 1;
        int max = 1;
        for (int diff = 1; diff <= 3; diff++) {
            if (diff == 1) {
                max = 10;
            }
            if (diff == 2) {
                max = 100;
            }
            if (diff == 3) {
                max = 1000;
            }
            for (int i = 0; i < 100000; i++) {
                rand = GuessNumber.randomGenerator(diff);
                if (rand > max) {
                    fail("More than max allowed, got " + rand);
                }
                if (rand < min) {
                    fail("Less than min allowed, got " + rand);
                }
            }
        }
    }

    @Test
    void isNumber() {
        assertTrue(GuessNumber.isNumber("50"));
        assertTrue(GuessNumber.isNumber("50000"));
        assertTrue(GuessNumber.isNumber("5"));
        assertFalse(GuessNumber.isNumber("Test"));
        assertFalse(GuessNumber.isNumber("4757T"));
        assertFalse(GuessNumber.isNumber("576&"));
    }
}