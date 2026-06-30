package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    void testProcessDataWithMock() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("users")).thenReturn("user list from api");

        MyService service = new MyService(mockApi);
        String result = service.processData("users");

        assertEquals("USER LIST FROM API", result);
    }

    @Test
    void testProcessDataReturnsNoDataWhenNull() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("empty")).thenReturn(null);

        MyService service = new MyService(mockApi);
        String result = service.processData("empty");

        assertEquals("No data available", result);
    }

    @Test
    void testProcessDataReturnsNoDataWhenEmpty() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("blank")).thenReturn("");

        MyService service = new MyService(mockApi);
        String result = service.processData("blank");

        assertEquals("No data available", result);
    }

    @Test
    void testGreetUserWithMock() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.sendNotification(eq("user123"), anyString())).thenReturn(true);

        MyService service = new MyService(mockApi);
        boolean sent = service.greetUser("user123");

        assertTrue(sent);
    }

    @Test
    void testGreetUserFails() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.sendNotification(anyString(), anyString())).thenReturn(false);

        MyService service = new MyService(mockApi);
        boolean sent = service.greetUser("user456");

        assertFalse(sent);
    }
}
