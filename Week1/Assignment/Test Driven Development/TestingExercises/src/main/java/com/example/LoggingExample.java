package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("Application started successfully");

        String username = "sampath";
        logger.info("User '{}' is attempting to log in", username);
        logger.debug("Looking up user '{}' in the database", username);

        int loginAttempts = 4;
        if (loginAttempts > 3) {
            logger.warn("User '{}' has {} failed login attempts", username, loginAttempts);
        }

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Math error occurred: {}", e.getMessage());
            logger.error("Full exception details", e);
        }

        logger.trace("This is a trace message - very detailed debugging info");

        logger.info("Application finished");
    }
}
