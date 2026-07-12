package com.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Exercise 2: Verifying Interactions
 * 
 * Demonstrates verifying that a method on the mock object
 * was called with the expected arguments during execution.
 */
public class VerifyingInteractionsTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Call the method through the service
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify that getData() was called exactly once on the mock
        verify(mockApi).getData();
    }

    @Test
    public void testVerifyNoMoreInteractions() {
        // 1. Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Call the method through the service
        MyService service = new MyService(mockApi);
        service.fetchData();

        // 3. Verify getData() was called once, and no other interactions occurred
        verify(mockApi, times(1)).getData();
        verifyNoMoreInteractions(mockApi);
    }
}
