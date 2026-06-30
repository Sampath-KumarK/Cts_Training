package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {
    }

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via constructor.");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService: BookRepository injected via setter.");
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public List<String> getAllBooks() {
        System.out.println("BookService: Getting all books...");
        return bookRepository.findAllBooks();
    }

    public void addBook(String book) {
        System.out.println("BookService: Adding book - " + book);
        bookRepository.addBook(book);
    }

    public boolean removeBook(String book) {
        System.out.println("BookService: Removing book - " + book);
        return bookRepository.removeBook(book);
    }
}
