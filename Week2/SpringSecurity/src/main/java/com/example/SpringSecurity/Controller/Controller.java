
package com.example.SpringSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.Module.Student;
import com.example.SpringSecurity.Repository.StudentRepository;
@RestController
@RequestMapping
public class Controller {

    @Autowired
    private StudentRepository studentrepo;

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @GetMapping("/students")
    public String hello1() {
        return "Now i am a authenticated user";
    }
    @GetMapping("/dummy")
    public String hello2() {
        return "Now i am a authenticated user and i can see all the students";
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentrepo.save(student);
    }
}