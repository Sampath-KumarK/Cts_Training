package com.example.Sun_eve.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Sun_eve.Entity.UserEntity;
import com.example.Sun_eve.Exception.UserNotFoundException;
import com.example.Sun_eve.Modules.User;
import com.example.Sun_eve.Repository.UserRepository;
@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserRepository userrepo;

    @GetMapping("/get")
    public String getUser() {
        return "Hello, User!";
    }
    @GetMapping("/getAll")
    public List<User> getAlluser(){
        return Arrays.asList(
            new User(1L, "John Doe", "john.doe@example.com"),
            new User(2L, "Jane Smith", "jane.smith@example.com")
        );
    }
    @GetMapping("/getfromdb")
    public List<UserEntity> getUserFromDB(){
        return userrepo.findAll();
    }
    @PostMapping("/add")
    public String addUser(@RequestBody UserEntity user) {
        userrepo.save(user);
        return "User added successfully!";
    }
    @GetMapping("/getbyid/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userrepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userrepo.deleteById(id);
        return "User deleted successfully!";
    }
    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        if (userrepo.existsById(id)) {
            user.setId(id);
            userrepo.save(user);
            return "User updated successfully!";
        } else {
            throw new UserNotFoundException(id);
        }
    }
}
