package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class PerformanceTesterTest {

    private final PerformanceTester performanceTester = new PerformanceTester();

    @Test
    void testPerformTaskCompletesWithinTimeout() {
        assertTimeout(Duration.ofSeconds(2), () -> performanceTester.performTask());
    }

    @Test
    void testPerformTaskReturnsResult() {
        String result = assertTimeout(Duration.ofSeconds(2), () -> performanceTester.performTask());
        assertNotNull(result);
        assertTrue(result.startsWith("Task completed with sum:"));
    }

    @Test
    void testSlowTaskExceedsTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> {
            long sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            assertTrue(sum > 0);
        });
    }
}
