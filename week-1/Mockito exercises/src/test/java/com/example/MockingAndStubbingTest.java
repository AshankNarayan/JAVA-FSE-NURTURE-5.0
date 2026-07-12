package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Exercise 1: Mocking and Stubbing
 * 
 * Demonstrates creating a mock object for an external API,
 * stubbing its methods to return predefined values,
 * and using the mock in a test case.
 */
public class MockingAndStubbingTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Use the mock object in the service under test
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // 4. Assert the result matches the stubbed value
        assertEquals("Mock Data", result);
    }
}
