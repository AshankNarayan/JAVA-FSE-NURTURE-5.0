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
        System.out.println("=== Loading Application Context ===");
        // Load the Spring Application Context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n=== Testing Setter Injection ===");
        // Retrieve the Setter Injected BookService bean
        BookService serviceWithSetter = context.getBean("bookServiceSetter", BookService.class);
        List<String> setterBooks = serviceWithSetter.getAllBooks();
        System.out.println("Books in Setter Service:");
        for (String book : setterBooks) {
            System.out.println("  * " + book);
        }

        System.out.println("\n=== Testing Constructor Injection ===");
        // Retrieve the Constructor Injected BookService bean
        BookService serviceWithConstructor = context.getBean("bookServiceConstructor", BookService.class);
        List<String> constructorBooks = serviceWithConstructor.getAllBooks();
        System.out.println("Books in Constructor Service:");
        for (String book : constructorBooks) {
            System.out.println("  * " + book);
        }

        // Test modification via setter service and verify it reflects in constructor service (sharing the same repository singleton bean)
        System.out.println("\n=== Testing Shared Repository Bean ===");
        System.out.println("Adding book via Setter-injected service...");
        serviceWithSetter.addBook("Spring in Action by Craig Walls");
        
        System.out.println("Listing books from Constructor-injected service to verify repository state:");
        for (String book : serviceWithConstructor.getAllBooks()) {
            System.out.println("  * " + book);
        }

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
