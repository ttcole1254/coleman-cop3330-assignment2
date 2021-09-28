package ex37;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @Test
    void generatePassword() {
    }

    @Test
    void shuffle() {
    }

    @Test
    void randomGenerator() {
        int rand;
        int min = 0;
        int max = 20;
        for (int i = 0; i < 100000; i++) {
            rand = PasswordGenerator.randomGenerator(0, 20);
            if (rand > max) {
                fail("More than max allowed, got " + rand);
            }
            if (rand < min) {
                fail("Less than min allowed, got " + rand);
            }
        }
    }

    @Test
    void isNumber() {
        assertTrue(PasswordGenerator.isNumber("50"));
        assertTrue(PasswordGenerator.isNumber("50000"));
        assertTrue(PasswordGenerator.isNumber("5"));
        assertFalse(PasswordGenerator.isNumber("Test"));
        assertFalse(PasswordGenerator.isNumber("4757T"));
        assertFalse(PasswordGenerator.isNumber("576&"));
    }
}