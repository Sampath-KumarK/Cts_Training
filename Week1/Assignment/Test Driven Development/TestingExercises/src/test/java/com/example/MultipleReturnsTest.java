package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultipleReturnsTest {

    @Test
    void testMultipleReturnValues() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("data"))
                .thenReturn("first response")
                .thenReturn("second response")
                .thenReturn("third response");

        MyService service = new MyService(mockApi);

        assertEquals("FIRST RESPONSE", service.processData("data"));
        assertEquals("SECOND RESPONSE", service.processData("data"));
        assertEquals("THIRD RESPONSE", service.processData("data"));
    }

    @Test
    void testMultipleReturnValuesLastValueRepeats() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.fetchData("endpoint"))
                .thenReturn("value1")
                .thenReturn("value2");

        MyService service = new MyService(mockApi);

        assertEquals("VALUE1", service.processData("endpoint"));
        assertEquals("VALUE2", service.processData("endpoint"));
        assertEquals("VALUE2", service.processData("endpoint"));
    }
}
