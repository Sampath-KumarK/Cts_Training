package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class VerifyInteractionTest {

    @Test
    void testFetchDataCallsExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("orders")).thenReturn("order data");

        MyService service = new MyService(mockApi);
        service.processData("orders");

        verify(mockApi).fetchData("orders");
    }

    @Test
    void testFetchDataCalledOnce() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("products")).thenReturn("product info");

        MyService service = new MyService(mockApi);
        service.processData("products");

        verify(mockApi, times(1)).fetchData("products");
    }

    @Test
    void testGreetUserCallsSendNotification() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.sendNotification(anyString(), anyString())).thenReturn(true);

        MyService service = new MyService(mockApi);
        service.greetUser("sam");

        verify(mockApi).sendNotification(eq("sam"), eq("Hello, welcome to the system!"));
    }

    @Test
    void testFetchDataNeverCalledWithWrongEndpoint() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("items")).thenReturn("some items");

        MyService service = new MyService(mockApi);
        service.processData("items");

        verify(mockApi, never()).fetchData("users");
    }

    @Test
    void testNoOtherInteractions() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("reports")).thenReturn("report data");

        MyService service = new MyService(mockApi);
        service.processData("reports");

        verify(mockApi).fetchData("reports");
        verifyNoMoreInteractions(mockApi);
    }
}
