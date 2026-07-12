package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        // Demonstrate logging with parameters
        String user = "JohnDoe";
        logger.info("User {} has logged in successfully.", user);

        // Demonstrate logging an exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An arithmetic exception occurred: ", e);
        }
    }
}
