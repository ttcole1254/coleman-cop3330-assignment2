package ex33;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import ex32.GuessNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Magic8BallTest {

    @Test
    void randomGenerator() {
        int rand;
        int min = 0;
        int max = 3;
        for (int i = 0; i < 100000; i++) {
            rand = Magic8Ball.randomGenerator(0, 3);
            if (rand > max) {
                fail("More than max allowed, got " + rand);
            }
            if (rand < min) {
                fail("Less than min allowed, got " + rand);
            }
        }
    }
}