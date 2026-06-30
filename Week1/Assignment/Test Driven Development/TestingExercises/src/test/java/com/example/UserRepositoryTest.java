package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        User user1 = new User();
        user1.setName("Sampath");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Sampath");
        userRepository.save(user2);

        User user3 = new User();
        user3.setName("Kumar");
        userRepository.save(user3);

        List<User> results = userRepository.findByName("Sampath");

        assertEquals(2, results.size());
        assertTrue(results.stream().allMatch(u -> u.getName().equals("Sampath")));
    }

    @Test
    void testFindByNameReturnsEmptyList() {
        List<User> results = userRepository.findByName("NonExistent");

        assertTrue(results.isEmpty());
    }
}
