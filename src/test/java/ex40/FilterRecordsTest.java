package ex40;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterRecordsTest {

    @Test
    void printEmpl() {
    }

    @Test
    void isString() {
        assertTrue(FilterRecords.isString("Stringtest"));
        assertTrue(FilterRecords.isString("String"));
        assertTrue(FilterRecords.isString("S"));
        assertFalse(FilterRecords.isString("Stringtest 454656"));
        assertFalse(FilterRecords.isString("67584"));
        assertFalse(FilterRecords.isString("4"));
    }
}