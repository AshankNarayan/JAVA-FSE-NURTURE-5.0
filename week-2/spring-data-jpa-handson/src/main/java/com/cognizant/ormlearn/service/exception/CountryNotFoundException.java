package com.cognizant.ormlearn.service.exception;

/**
 * Custom exception thrown when a country is not found by its code.
 */
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException() {
        super("Country not found!");
    }

    public CountryNotFoundException(String message) {
        super(message);
    }
}
