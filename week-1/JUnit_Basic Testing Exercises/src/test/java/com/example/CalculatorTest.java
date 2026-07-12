package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    // Setup method executed before each test
    @Before
    public void setUp() {
        System.out.println("Setting up test fixture: Creating Calculator instance...");
        calculator = new Calculator();
    }

    // Teardown method executed after each test
    @After
    public void tearDown() {
        System.out.println("Tearing down test fixture: Setting Calculator to null...");
        calculator = null;
    }

    @Test
    public void testAdd() {
        // 1. Arrange
        int a = 10;
        int b = 5;

        // 2. Act
        int result = calculator.add(a, b);

        // 3. Assert
        assertEquals("Addition result should be 15", 15, result);
    }

    @Test
    public void testSubtract() {
        // 1. Arrange
        int a = 20;
        int b = 8;

        // 2. Act
        int result = calculator.subtract(a, b);

        // 3. Assert
        assertEquals("Subtraction result should be 12", 12, result);
    }

    @Test
    public void testDivide() {
        // 1. Arrange
        int a = 10;
        int b = 4;

        // 2. Act
        double result = calculator.divide(a, b);

        // 3. Assert
        assertEquals("Division result should be 2.5", 2.5, result, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        // 1. Arrange
        int a = 10;
        int b = 0;

        // 2. Act (should throw IllegalArgumentException)
        calculator.divide(a, b);
        
        // 3. Assert is handled by the 'expected' parameter of the @Test annotation
    }
}
