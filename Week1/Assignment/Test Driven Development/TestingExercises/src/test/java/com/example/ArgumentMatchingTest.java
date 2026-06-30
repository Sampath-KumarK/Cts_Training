package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArgumentMatchingTest {

    @Test
    void testFetchDataWithAnyString() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData(anyString())).thenReturn("generic data");

        MyService service = new MyService(mockApi);
        String result = service.processData("anything");

        assertEquals("GENERIC DATA", result);
        verify(mockApi).fetchData(anyString());
    }

    @Test
    void testFetchDataWithSpecificArgument() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData(eq("users"))).thenReturn("user data");

        MyService service = new MyService(mockApi);
        String result = service.processData("users");

        assertEquals("USER DATA", result);
        verify(mockApi).fetchData(eq("users"));
    }

    @Test
    void testSendNotificationWithArgumentMatchers() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.sendNotification(anyString(), contains("welcome"))).thenReturn(true);

        MyService service = new MyService(mockApi);
        boolean result = service.greetUser("user1");

        assertTrue(result);
        verify(mockApi).sendNotification(eq("user1"), contains("welcome"));
    }
}
