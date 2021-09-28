package ex36;

/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Tyler Coleman
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void average() {
        ArrayList<Double> testArr = new ArrayList<>();
        testArr.add(5.0);
        testArr.add(6.0);
        testArr.add(7.0);
        assertEquals(6.0, Statistics.average(testArr));
    }

    @Test
    void max() {
        ArrayList<Double> testArr = new ArrayList<>();
        testArr.add(5.0);
        testArr.add(6.0);
        testArr.add(7.0);
        assertEquals(7.0, Statistics.max(testArr));
    }

    @Test
    void min() {
        ArrayList<Double> testArr = new ArrayList<>();
        testArr.add(5.0);
        testArr.add(6.0);
        testArr.add(7.0);
        assertEquals(5.0, Statistics.min(testArr));
    }

    @Test
    void std() {
        ArrayList<Double> testArr = new ArrayList<>();
        testArr.add(5.0);
        testArr.add(6.0);
        testArr.add(7.0);
        assertEquals(0.816496580927726, Statistics.std(testArr));
    }

    @Test
    void printOutput() {
    }

    @Test
    void statistics() {
    }

    @Test
    void addToArray() {
    }

    @Test
    void isNumber() {
        assertTrue(Statistics.isNumber("50"));
        assertTrue(Statistics.isNumber("50000"));
        assertTrue(Statistics.isNumber("5"));
        assertFalse(Statistics.isNumber("Test"));
        assertFalse(Statistics.isNumber("4757T"));
        assertFalse(Statistics.isNumber("576&"));
    }
}