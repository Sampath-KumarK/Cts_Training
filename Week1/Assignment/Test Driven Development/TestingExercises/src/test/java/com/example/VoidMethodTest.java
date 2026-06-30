package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class VoidMethodTest {

    @Test
    void testVoidMethodIsCalled() {
        Repository mockRepository = Mockito.mock(Repository.class);
        doNothing().when(mockRepository).saveData("test data");

        Service service = new Service(mockRepository);
        service.save("test data");

        verify(mockRepository).saveData("test data");
    }

    @Test
    void testVoidMethodCalledOnce() {
        Repository mockRepository = Mockito.mock(Repository.class);
        doNothing().when(mockRepository).saveData(anyString());

        Service service = new Service(mockRepository);
        service.save("sample");

        verify(mockRepository, times(1)).saveData("sample");
    }
}
