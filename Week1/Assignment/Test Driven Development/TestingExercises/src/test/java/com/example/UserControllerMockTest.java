package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetUserWithMockedService() throws Exception {
        User user = new User(1L, "Sampath");
        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Sampath"));

        verify(userService).getUserById(1L);
    }

    @Test
    void testCreateUserWithMockedService() throws Exception {
        User user = new User(1L, "Kumar");
        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                        .contentType("application/json")
                        .content("{\"id\":1,\"name\":\"Kumar\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kumar"));

        verify(userService).saveUser(any(User.class));
    }
}
