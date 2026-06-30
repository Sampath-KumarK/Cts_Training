package com.library.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Spring in Action");
        books.add("Effective Java");
        books.add("Clean Code");
    }

    public List<String> findAllBooks() {
        System.out.println("BookRepository: Finding all books...");
        return books;
    }

    public void addBook(String book) {
        books.add(book);
        System.out.println("BookRepository: Added book - " + book);
    }

    public boolean removeBook(String book) {
        boolean removed = books.remove(book);
        if (removed) {
            System.out.println("BookRepository: Removed book - " + book);
        } else {
            System.out.println("BookRepository: Book not found - " + book);
        }
        return removed;
    }
}
