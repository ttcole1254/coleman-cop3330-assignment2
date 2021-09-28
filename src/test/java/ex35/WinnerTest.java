package ex35;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnerTest {

    @Test
    void randomGenerator() {
        int rand;
        int min = 0;
        int max = 5;
        for (int i = 0; i < 100000; i++) {
            rand = Winner.randomGenerator(0, 5);
            if (rand > max) {
                fail("More than max allowed, got " + rand);
            }
            if (rand < min) {
                fail("Less than min allowed, got " + rand);
            }
        }
    }
}