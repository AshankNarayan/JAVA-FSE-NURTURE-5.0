package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Main class to load the Spring Application Context and test the configuration.
 * Demonstrates:
 *   - Exercise 1: Configuring a basic Spring application with XML beans.
 *   - Exercise 2: Dependency Injection (BookRepository injected into BookService via setter).
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        // Load the Spring Application Context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the context
        BookService bookService = context.getBean("bookService", BookService.class);

        // Test: Retrieve all books
        System.out.println("=== Library Management Application ===");
        System.out.println("\n--- Listing all books ---");
        List<String> books = bookService.getAllBooks();
        for (String book : books) {
            System.out.println("  * " + book);
        }

        // Test: Add a new book
        System.out.println("\n--- Adding a new book ---");
        bookService.addBook("Head First Design Patterns by Eric Freeman");

        // Test: Verify the book was added
        System.out.println("\n--- Updated book list ---");
        books = bookService.getAllBooks();
        for (String book : books) {
            System.out.println("  * " + book);
        }

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
