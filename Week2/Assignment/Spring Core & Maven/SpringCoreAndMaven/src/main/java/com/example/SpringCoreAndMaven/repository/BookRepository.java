package com.example.SpringCoreAndMaven.repository;

import com.example.SpringCoreAndMaven.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
