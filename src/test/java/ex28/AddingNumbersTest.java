package ex28;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddingNumbersTest {

    @Test
    void addNumbers() {
        assertEquals(15.0, AddingNumbers.addNumbers(new double[]{1, 2, 3, 4, 5}));
        assertEquals(247.0, AddingNumbers.addNumbers(new double[]{0, 200, 40, 2, 5}));
        assertEquals(302.8, AddingNumbers.addNumbers(new double[]{5.7, 200.9, 20.6, 24.7, 50.9}));
    }

    @Test
    void isNumber() {
        assertTrue(AddingNumbers.isNumber("50"));
        assertTrue(AddingNumbers.isNumber("50000"));
        assertTrue(AddingNumbers.isNumber("5"));
        assertFalse(AddingNumbers.isNumber("Test"));
        assertFalse(AddingNumbers.isNumber("4757T"));
        assertFalse(AddingNumbers.isNumber("576&"));
    }
}