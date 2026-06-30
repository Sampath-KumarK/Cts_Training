package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 5);
        assertEquals(8, result);
    }

    @Test
    void testSubtraction() {
        Calculator calc = new Calculator();
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    void testMultiplication() {
        Calculator calc = new Calculator();
        int result = calc.multiply(7, 3);
        assertEquals(21, result);
    }

    @Test
    void testDivision() {
        Calculator calc = new Calculator();
        int result = calc.divide(20, 5);
        assertEquals(4, result);
    }

    @Test
    void testDivisionByZeroThrowsException() {
        Calculator calc = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }

    @Test
    void testAddNegativeNumbers() {
        Calculator calc = new Calculator();
        int result = calc.add(-3, -7);
        assertEquals(-10, result);
    }

    @Test
    void testSubtractResultNegative() {
        Calculator calc = new Calculator();
        int result = calc.subtract(5, 12);
        assertEquals(-7, result);
    }
}
