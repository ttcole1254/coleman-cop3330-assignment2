package ex27;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void checkIfNotEmpty() {
        assertTrue(Validator.checkIfNotEmpty("1"));
        assertTrue(Validator.checkIfNotEmpty("s"));
        assertTrue(Validator.checkIfNotEmpty("&&&&&&&&&"));
        assertFalse(Validator.checkIfNotEmpty(""));
        assertFalse(Validator.checkIfNotEmpty(""));
        assertFalse(Validator.checkIfNotEmpty(""));
    }

    @Test
    void checkIf2Char() {
        assertTrue(Validator.checkIf2Char("36"));
        assertTrue(Validator.checkIf2Char("36gjfjgdfgvr"));
        assertTrue(Validator.checkIf2Char("ae"));
        assertFalse(Validator.checkIf2Char("3"));
        assertFalse(Validator.checkIf2Char("a"));
        assertFalse(Validator.checkIf2Char("#"));
    }

    @Test
    void checkIDFormat() {
        assertTrue(Validator.checkIDFormat("aa-8645"));
        assertTrue(Validator.checkIDFormat("ZZ-1111"));
        assertTrue(Validator.checkIDFormat("AK-0000"));
        assertFalse(Validator.checkIDFormat("aa3-8645"));
        assertFalse(Validator.checkIDFormat("ZZ-11113"));
        assertFalse(Validator.checkIDFormat("AK*0000"));
        assertFalse(Validator.checkIDFormat("AK0000"));
    }

    @Test
    void checkIfNumber() {
        assertTrue(Validator.checkIfNumber("45367"));
        assertTrue(Validator.checkIfNumber("11111"));
        assertTrue(Validator.checkIfNumber("00000"));
        assertFalse(Validator.checkIfNumber("453675"));
        assertFalse(Validator.checkIfNumber("11111323456245"));
        assertFalse(Validator.checkIfNumber("00"));
    }

    @Test
    void validateInput() {
        assertEquals("The first name must be filled in.\nThe first name must be at least 2 characters long.\n", Validator.validateInput("", "Name", "34567", "AA-1234"));
        assertEquals("The last name must be filled in.\nThe last name must be at least 2 characters long.\n", Validator.validateInput("First", "", "45678", "AA-3456"));
        assertEquals("The first name must be at least 2 characters long.\n", Validator.validateInput("A", "Last", "34567", "AA-1234"));
        assertEquals("The last name must be at least 2 characters long.\n", Validator.validateInput("First", "A", "34567", "AA-1234"));
        assertEquals("The employee ID must be in the format of AA-1234.\n", Validator.validateInput("First", "Last", "34567", "AA1234"));
        assertEquals("The zip code must be a 5 digit number.\n", Validator.validateInput("First", "Last", "434", "AA-5678"));
        assertEquals("There were no errors found.", Validator.validateInput("First", "Last", "00000", "ZA-1234"));
    }
}