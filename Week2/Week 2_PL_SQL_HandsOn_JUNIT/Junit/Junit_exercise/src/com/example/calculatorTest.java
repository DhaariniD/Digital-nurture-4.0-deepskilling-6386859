package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class calculatorTest {

    private Calculator calculator;

    // Setup: runs before each @Test
    @Before
    public void setUp() {
        System.out.println("Setting up Calculator instance...");
        calculator = new Calculator();
    }

    // Teardown: runs after each @Test
    @After
    public void tearDown() {
        System.out.println("Cleaning up Calculator instance...");
        calculator = null;
    }

    @Test
    public void testAddition_AAA() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction_AAA() {
        // Arrange
        int a = 10, b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }
}
