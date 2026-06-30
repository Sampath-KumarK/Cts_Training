package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void testAddEquals() {
        Calculator calc = new Calculator();
        assertEquals(10, calc.add(4, 6));
    }

    @Test
    void testIsPositiveTrue() {
        Calculator calc = new Calculator();
        assertTrue(calc.isPositive(5));
    }

    @Test
    void testIsPositiveFalse() {
        Calculator calc = new Calculator();
        assertFalse(calc.isPositive(-3));
    }

    @Test
    void testZeroIsNotPositive() {
        Calculator calc = new Calculator();
        assertFalse(calc.isPositive(0));
    }

    @Test
    void testNotNullObject() {
        Calculator calc = new Calculator();
        assertNotNull(calc);
    }

    @Test
    void testNullValue() {
        String name = null;
        assertNull(name);
    }

    @Test
    void testArraysAreEqual() {
        int[] expected = {2, 4, 6, 8};
        int[] actual = {2, 4, 6, 8};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testDivideByZeroException() {
        Calculator calc = new Calculator();
        ArithmeticException thrown = assertThrows(ArithmeticException.class, () -> {
            calc.divide(15, 0);
        });
        assertEquals("Cannot divide by zero", thrown.getMessage());
    }

    @Test
    void testEvenNumber() {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(8));
    }

    @Test
    void testOddNumber() {
        EvenChecker checker = new EvenChecker();
        assertFalse(checker.isEven(7));
    }

    @Test
    void testSubtractNotEqual() {
        Calculator calc = new Calculator();
        assertNotEquals(0, calc.subtract(10, 3));
    }
}
