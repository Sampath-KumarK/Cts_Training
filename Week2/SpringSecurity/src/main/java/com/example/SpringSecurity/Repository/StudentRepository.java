package com.example.SpringSecurity.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurity.Module.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByName(String name);
}