package com.library.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class responsible for data access operations related to books.
 */
public class BookRepository {

    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        // Pre-populate with some sample books
        books.add("Effective Java by Joshua Bloch");
        books.add("Clean Code by Robert C. Martin");
        books.add("Design Patterns by Gang of Four");
    }

    /**
     * Returns all books in the repository.
     */
    public List<String> findAllBooks() {
        return books;
    }

    /**
     * Adds a new book to the repository.
     */
    public void addBook(String book) {
        books.add(book);
        System.out.println("BookRepository: Added book - " + book);
    }
}
