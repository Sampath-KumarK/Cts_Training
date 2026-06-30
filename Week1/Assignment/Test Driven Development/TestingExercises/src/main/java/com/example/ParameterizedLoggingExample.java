package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "sampath";
        int age = 25;
        double score = 95.5;

        logger.info("User {} logged in", username);
        logger.info("User {} is {} years old", username, age);
        logger.info("User {} scored {} in the test", username, score);
        logger.debug("Processing request for user: {}, age: {}, score: {}", username, age, score);
        logger.warn("User {} has exceeded the maximum login attempts: {}", username, 5);
        logger.error("Failed to process request for user: {} with error code: {}", username, 500);
    }
}
