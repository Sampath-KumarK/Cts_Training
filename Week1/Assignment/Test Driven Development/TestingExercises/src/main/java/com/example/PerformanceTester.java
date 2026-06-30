package com.example;

public class PerformanceTester {

    public String performTask() {
        long sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        return "Task completed with sum: " + sum;
    }

    public String performSlowTask() throws InterruptedException {
        Thread.sleep(5000);
        return "Slow task completed";
    }
}
