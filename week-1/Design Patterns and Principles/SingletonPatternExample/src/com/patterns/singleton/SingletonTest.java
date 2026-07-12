package com.patterns.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Singleton Pattern Implementation ===");

        // Get the singleton instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Perform some logging
        logger1.log("Initializing application...");
        logger2.log("Performing database operation...");
        logger1.log("Process completed successfully.");

        // Print hash codes of both instances
        System.out.println("\nLogger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());

        // Verify that both references point to the exact same instance
        if (logger1 == logger2) {
            System.out.println("\nSUCCESS: Both references point to the same Logger instance. Singleton pattern works!");
        } else {
            System.out.println("\nFAILURE: References point to different Logger instances. Singleton pattern failed!");
        }
    }
}
