package ex29;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadInputTest {

    @Test
    void isNumber() {
        assertTrue(BadInput.isNumber("50"));
        assertTrue(BadInput.isNumber("50000"));
        assertTrue(BadInput.isNumber("5"));
        assertFalse(BadInput.isNumber("Test"));
        assertFalse(BadInput.isNumber("4757T"));
        assertFalse(BadInput.isNumber("576&"));
    }

    @Test
    void rateOfReturn() {
        assertEquals(8.0, BadInput.rateOfReturn(9.0));
        assertEquals(72.0, BadInput.rateOfReturn(1.0));
        assertEquals(1.0, BadInput.rateOfReturn(72.0));
    }
}