package com.dsa.search;

public class SearchAlgorithms {

    /**
     * Linear Search Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param products Unsorted or sorted array of products
     * @param targetId Product ID to search for
     * @return Product if found, null otherwise
     */
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equalsIgnoreCase(targetId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Binary Search Algorithm
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * @param products Must be sorted by productId
     * @param targetId Product ID to search for
     * @return Product if found, null otherwise
     */
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareToIgnoreCase(targetId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return null; // Not found
    }
}
