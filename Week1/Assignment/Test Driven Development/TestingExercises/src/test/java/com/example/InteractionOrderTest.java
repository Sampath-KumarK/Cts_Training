package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class InteractionOrderTest {

    @Test
    void testMethodsCalledInOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("users")).thenReturn("user data");
        when(mockApi.sendNotification(anyString(), anyString())).thenReturn(true);

        MyService service = new MyService(mockApi);
        service.processData("users");
        service.greetUser("sam");

        InOrder inOrder = Mockito.inOrder(mockApi);
        inOrder.verify(mockApi).fetchData("users");
        inOrder.verify(mockApi).sendNotification(eq("sam"), anyString());
    }

    @Test
    void testMultipleCallsInOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData(anyString())).thenReturn("data");

        MyService service = new MyService(mockApi);
        service.processData("first");
        service.processData("second");
        service.processData("third");

        InOrder inOrder = Mockito.inOrder(mockApi);
        inOrder.verify(mockApi).fetchData("first");
        inOrder.verify(mockApi).fetchData("second");
        inOrder.verify(mockApi).fetchData("third");
    }
}
