package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    @Test
    void testServiceWithMockRepository() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData()).thenReturn("Mock Data");

        Service service = new Service(mockRepository);
        String result = service.processData();

        assertEquals("Processed Mock Data", result);
    }

    @Test
    void testServiceSaveCallsRepository() {
        Repository mockRepository = mock(Repository.class);
        doNothing().when(mockRepository).saveData("new data");

        Service service = new Service(mockRepository);
        service.save("new data");

        verify(mockRepository).saveData("new data");
    }
}
