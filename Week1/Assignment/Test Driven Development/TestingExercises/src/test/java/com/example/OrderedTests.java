package com.example;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void testFirst() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(2)
    void testSecond() {
        assertEquals(4, 2 + 2);
    }

    @Test
    @Order(3)
    void testThird() {
        assertEquals(6, 3 + 3);
    }

    @Test
    @Order(4)
    void testFourth() {
        assertEquals(8, 4 + 4);
    }
}
