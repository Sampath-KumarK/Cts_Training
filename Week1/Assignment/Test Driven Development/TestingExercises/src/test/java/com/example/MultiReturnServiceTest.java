package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultiReturnServiceTest {

    @Test
    void testServiceWithMultipleReturnValues() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        Service service = new Service(mockRepository);

        String firstResult = service.processData();
        String secondResult = service.processData();

        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);
    }

    @Test
    void testThirdCallReturnsLastStubbedValue() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData())
                .thenReturn("Alpha")
                .thenReturn("Beta");

        Service service = new Service(mockRepository);

        assertEquals("Processed Alpha", service.processData());
        assertEquals("Processed Beta", service.processData());
        assertEquals("Processed Beta", service.processData());
    }
}
