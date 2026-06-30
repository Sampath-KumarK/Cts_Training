package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetExistingUserByIdThrowsException() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> userService.getExistingUserById(99L));
    }

    @Test
    void testGetExistingUserByIdReturnsUser() {
        User user = new User(1L, "Sampath");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getExistingUserById(1L);

        assertNotNull(result);
        assertEquals("Sampath", result.getName());
    }
}
