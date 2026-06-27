package com.example.SpringSecurity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.Exception.UserNotfoundException;
import com.example.SpringSecurity.Module.Student;
import com.example.SpringSecurity.Repository.StudentRepository;

@Service
public class StudentsServices implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        Student student = studentRepository.findByName(username)
                .orElseThrow(() ->
                        new UserNotfoundException("User not found with name: " + username));

        return User.withUsername(student.getName())
                .password(student.getPassword())
                .roles("USER")
                .build();
    }

}