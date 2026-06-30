package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    private final ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test
    void testThrowExceptionThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> exceptionThrower.throwException());
    }

    @Test
    void testThrowExceptionMessage() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> exceptionThrower.throwException()
        );
        assertEquals("Invalid argument provided", exception.getMessage());
    }

    @Test
    void testDivideByZeroThrowsArithmeticException() {
        assertThrows(ArithmeticException.class, () -> exceptionThrower.divideNumbers(10, 0));
    }

    @Test
    void testDivideByZeroExceptionMessage() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> exceptionThrower.divideNumbers(10, 0)
        );
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testDivideValidNumbers() {
        assertEquals(5, exceptionThrower.divideNumbers(10, 2));
    }
}
