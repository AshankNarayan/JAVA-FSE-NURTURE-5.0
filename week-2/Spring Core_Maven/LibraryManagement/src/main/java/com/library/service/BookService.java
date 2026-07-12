package com.library.service;

import com.library.repository.BookRepository;
import java.util.List;

/**
 * Service class that provides business logic for managing books.
 * Depends on BookRepository via setter injection (Exercise 2).
 */
public class BookService {

    private BookRepository bookRepository;

    // Default constructor (required for setter injection)
    public BookService() {
        System.out.println("BookService: Instantiated using default constructor.");
    }

    // Parameterized constructor (required for constructor injection)
    public BookService(BookRepository bookRepository) {
        System.out.println("BookService: Instantiated using parameterized constructor (Constructor Injection).");
        this.bookRepository = bookRepository;
    }

    /**
     * Setter method for dependency injection of BookRepository.
     * Spring uses this setter to wire the BookRepository bean.
     */
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("BookService: Setting BookRepository dependency (Setter Injection).");
        this.bookRepository = bookRepository;
    }

    /**
     * Retrieves all books from the repository and displays them.
     */
    public List<String> getAllBooks() {
        List<String> books = bookRepository.findAllBooks();
        System.out.println("BookService: Retrieved " + books.size() + " books.");
        return books;
    }

    /**
     * Adds a new book via the repository.
     */
    public void addBook(String book) {
        bookRepository.addBook(book);
        System.out.println("BookService: Book added successfully.");
    }
}
