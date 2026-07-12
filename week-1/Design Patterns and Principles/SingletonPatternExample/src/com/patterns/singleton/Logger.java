package com.patterns.singleton;

public class Logger {
    // Private static instance of the same class
    private static volatile Logger instance;

    // Private constructor to prevent instantiation from other classes
    private Logger() {
        // Prevent instantiation via reflection
        if (instance != null) {
            throw new IllegalStateException("Instance already created.");
        }
    }

    // Public static method to get the single instance of the Logger class
    public static Logger getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Logger.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // A sample log method to demonstrate logging functionality
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
