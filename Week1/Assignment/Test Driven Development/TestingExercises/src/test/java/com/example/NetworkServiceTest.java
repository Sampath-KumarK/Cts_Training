package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {

    @Test
    void testServiceWithMockNetworkClient() {
        NetworkClient mockNetworkClient = mock(NetworkClient.class);
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        assertEquals("Connected to Mock Connection", result);
    }

    @Test
    void testDisconnectCallsNetworkClient() {
        NetworkClient mockNetworkClient = mock(NetworkClient.class);
        doNothing().when(mockNetworkClient).disconnect();

        NetworkService networkService = new NetworkService(mockNetworkClient);
        networkService.disconnectFromServer();

        verify(mockNetworkClient).disconnect();
    }
}
