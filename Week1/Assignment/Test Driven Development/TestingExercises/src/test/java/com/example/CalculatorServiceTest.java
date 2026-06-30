package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5, calculatorService.add(-2, -3));
    }

    @Test
    void testAddZero() {
        assertEquals(0, calculatorService.add(0, 0));
    }

    @Test
    void testAddPositiveAndNegative() {
        assertEquals(1, calculatorService.add(3, -2));
    }
}
