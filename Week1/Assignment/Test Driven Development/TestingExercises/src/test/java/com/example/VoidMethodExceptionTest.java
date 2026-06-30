package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VoidMethodExceptionTest {

    @Test
    void testVoidMethodThrowsException() {
        Repository mockRepository = Mockito.mock(Repository.class);
        doThrow(new RuntimeException("Database error")).when(mockRepository).saveData("bad data");

        Service service = new Service(mockRepository);

        assertThrows(RuntimeException.class, () -> service.save("bad data"));
        verify(mockRepository).saveData("bad data");
    }

    @Test
    void testVoidMethodThrowsExceptionWithMessage() {
        Repository mockRepository = Mockito.mock(Repository.class);
        doThrow(new IllegalStateException("Connection lost")).when(mockRepository).saveData("fail");

        Service service = new Service(mockRepository);

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> service.save("fail")
        );
        assertEquals("Connection lost", exception.getMessage());
    }
}
