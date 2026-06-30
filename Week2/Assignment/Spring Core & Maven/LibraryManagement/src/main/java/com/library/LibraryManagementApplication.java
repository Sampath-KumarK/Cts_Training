package com.library;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication {

    public static void main(String[] args) {

        System.out.println("  Library Management Application - Spring Core");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        System.out.println("  Exercise 1 & 5: Basic Spring Configuration & IoC Container");


        System.out.println("Spring Application Context loaded successfully!");
        System.out.println("Beans defined in context: ");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println("  -> " + beanName);
        }
        System.out.println();

  
        System.out.println("  Exercise 2: Dependency Injection (Setter Injection)");


        BookService bookServiceSetter = (BookService) context.getBean("bookServiceSetter");
        System.out.println("BookService (Setter) bean retrieved: " + bookServiceSetter);
        System.out.println("BookRepository injected: " + (bookServiceSetter.getBookRepository() != null));

        List<String> books = bookServiceSetter.getAllBooks();
        System.out.println("Books available: " + books);
        System.out.println();

   
        System.out.println("  Exercise 7: Constructor Injection");
   

        BookService bookServiceConstructor = (BookService) context.getBean("bookServiceConstructor");
        System.out.println("BookService (Constructor) bean retrieved: " + bookServiceConstructor);
        System.out.println("BookRepository injected: " + (bookServiceConstructor.getBookRepository() != null));

        bookServiceConstructor.addBook("Head First Design Patterns");
        List<String> updatedBooks = bookServiceConstructor.getAllBooks();
        System.out.println("Updated Books: " + updatedBooks);
        System.out.println();

        System.out.println("  Exercise 7: Verifying Both Injection Types");
        

        System.out.println("Constructor-injected BookService works: " +
                (bookServiceConstructor.getBookRepository() != null));
        System.out.println("Setter-injected BookService works: " +
                (bookServiceSetter.getBookRepository() != null));

        boolean sameBeanReference = bookServiceConstructor.getBookRepository() == bookServiceSetter.getBookRepository();
        System.out.println("Both services share the same BookRepository instance (singleton): " + sameBeanReference);

        System.out.println();

        System.out.println("  All Spring Core Exercises Completed Successfully!");


        ((ClassPathXmlApplicationContext) context).close();
    }
}
