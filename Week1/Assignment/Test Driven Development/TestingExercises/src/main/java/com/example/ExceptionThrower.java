package com.example;

public class ExceptionThrower {

    public void throwException() {
        throw new IllegalArgumentException("Invalid argument provided");
    }

    public int divideNumbers(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
