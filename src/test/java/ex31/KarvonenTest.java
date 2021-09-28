package ex31;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KarvonenTest {

    @Test
    void isNumber() {
        assertTrue(Karvonen.isNumber("50"));
        assertTrue(Karvonen.isNumber("50000"));
        assertTrue(Karvonen.isNumber("5"));
        assertFalse(Karvonen.isNumber("Test"));
        assertFalse(Karvonen.isNumber("4757T"));
        assertFalse(Karvonen.isNumber("576&"));
    }
}