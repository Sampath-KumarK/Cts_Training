package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorAAATest {

    private Calculator calculator;

    @BeforeAll
    static void setupOnce() {
        System.out.println(">> Starting Calculator AAA tests...");
    }

    @AfterAll
    static void teardownOnce() {
        System.out.println(">> All Calculator AAA tests finished.");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("  -> Created new Calculator instance");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("  -> Cleaned up Calculator instance");
    }

    @Test
    void testAddUsingAAA() {
        int num1 = 15;
        int num2 = 25;

        int result = calculator.add(num1, num2);

        assertEquals(40, result);
    }

    @Test
    void testSubtractUsingAAA() {
        int a = 50;
        int b = 20;

        int result = calculator.subtract(a, b);

        assertEquals(30, result);
    }

    @Test
    void testMultiplyUsingAAA() {
        int x = 6;
        int y = 9;

        int product = calculator.multiply(x, y);

        assertEquals(54, product);
    }

    @Test
    void testDivideUsingAAA() {
        int dividend = 100;
        int divisor = 4;

        int quotient = calculator.divide(dividend, divisor);

        assertEquals(25, quotient);
    }

    @Test
    void testDivideByZeroUsingAAA() {
        int dividend = 42;
        int divisor = 0;

        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(dividend, divisor);
        });
    }

    @Test
    void testIsPositiveUsingAAA() {
        int positiveNum = 10;
        int negativeNum = -5;

        boolean resultPositive = calculator.isPositive(positiveNum);
        boolean resultNegative = calculator.isPositive(negativeNum);

        assertTrue(resultPositive);
        assertFalse(resultNegative);
    }
}
