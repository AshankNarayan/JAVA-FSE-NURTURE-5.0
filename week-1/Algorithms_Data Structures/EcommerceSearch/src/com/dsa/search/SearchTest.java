package com.dsa.search;

import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== E-commerce Platform Search Test ===");

        // Setup unsorted products array
        Product[] products = {
            new Product("P105", "Wireless Mouse", "Electronics"),
            new Product("P101", "Gaming Laptop", "Electronics"),
            new Product("P103", "Mechanical Keyboard", "Electronics"),
            new Product("P102", "Noise Cancelling Headphones", "Electronics"),
            new Product("P104", "Smartphone", "Electronics")
        };

        // Linear Search Test
        System.out.println("\n--- Testing Linear Search ---");
        String targetId = "P103";
        System.out.println("Searching for Product ID: " + targetId);
        long startTime = System.nanoTime();
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        long endTime = System.nanoTime();
        System.out.println("Result: " + (resultLinear != null ? resultLinear : "Product Not Found"));
        System.out.println("Linear Search Time Taken: " + (endTime - startTime) + " ns");

        // Binary Search Test
        System.out.println("\n--- Testing Binary Search ---");
        System.out.println("Sorting products by Product ID for Binary Search...");
        Arrays.sort(products);
        for (Product p : products) {
            System.out.println("  " + p);
        }

        System.out.println("\nSearching for Product ID: " + targetId);
        startTime = System.nanoTime();
        Product resultBinary = SearchAlgorithms.binarySearch(products, targetId);
        endTime = System.nanoTime();
        System.out.println("Result: " + (resultBinary != null ? resultBinary : "Product Not Found"));
        System.out.println("Binary Search Time Taken: " + (endTime - startTime) + " ns");

        // Searching for non-existent product
        String searchNonExistent = "P999";
        System.out.println("\nSearching for non-existent Product ID: " + searchNonExistent);
        Product resultNotFound = SearchAlgorithms.binarySearch(products, searchNonExistent);
        System.out.println("Result: " + (resultNotFound != null ? resultNotFound : "Product Not Found"));
    }
}
