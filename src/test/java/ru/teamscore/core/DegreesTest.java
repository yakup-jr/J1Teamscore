package ru.teamscore.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DegreesTest {

    @Test
     void calculateCountDigits_SimplePowers() {
        assertEquals(4, Degrees.calculateCountDigits(2, 10));
        assertEquals(2, Degrees.calculateCountDigits(3, 4));
        assertEquals(3, Degrees.calculateCountDigits(5, 3));
    }

    @Test
    void calculateCountDigits_ExponentIsZero_ReturnsOne() {
        assertEquals(1, Degrees.calculateCountDigits(123, 0));
        assertEquals(1, Degrees.calculateCountDigits(99999, 0));
    }

    @Test
    void calculateCountDigits_BaseIsOne_ReturnsOne() {
        assertEquals(1, Degrees.calculateCountDigits(1, 100));
        assertEquals(1, Degrees.calculateCountDigits(1, 5));
    }

    @Test
    void calculateCountDigits_PowersOfTen_BoundaryCheck() {
        assertEquals(2, Degrees.calculateCountDigits(10, 1));
        assertEquals(3, Degrees.calculateCountDigits(10, 2));
        assertEquals(4, Degrees.calculateCountDigits(10, 3));
        assertEquals(2, Degrees.calculateCountDigits(9, 2));
    }

    @Test
    void calculateCountDigits_LargeExponent() {
        assertEquals(302, Degrees.calculateCountDigits(2, 1000));
    }

    @Test
    void calculateCountDigits_MaxIntegerBase() {
        assertEquals(19, Degrees.calculateCountDigits(Integer.MAX_VALUE, 2));
    }

}
