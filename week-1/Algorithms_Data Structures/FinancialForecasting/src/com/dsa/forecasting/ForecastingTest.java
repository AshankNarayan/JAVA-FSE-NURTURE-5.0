package com.dsa.forecasting;

public class ForecastingTest {
    public static void main(String[] args) {
        System.out.println("=== Financial Forecasting Test ===");

        double presentValue = 1000.0;  // Initial principal
        double growthRate = 0.05;       // 5% annual growth rate
        int periods = 10;               // 10 years prediction horizon

        System.out.println("Initial Investment (PV): $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Forecast Period: " + periods + " years");

        // 1. Recursive calculation
        long startTime = System.nanoTime();
        double futureValueRecursive = FinancialForecasting.calculateFutureValue(presentValue, growthRate, periods);
        long endTime = System.nanoTime();
        System.out.printf("\n[Recursive] Future Value: $%.2f (Time taken: %d ns)%n", 
            futureValueRecursive, (endTime - startTime));

        // 2. Iterative calculation (Optimized)
        startTime = System.nanoTime();
        double futureValueIterative = FinancialForecasting.calculateFutureValueIterative(presentValue, growthRate, periods);
        endTime = System.nanoTime();
        System.out.printf("[Iterative] Future Value: $%.2f (Time taken: %d ns)%n", 
            futureValueIterative, (endTime - startTime));
            
        // Validate result
        if (Math.abs(futureValueRecursive - futureValueIterative) < 0.001) {
            System.out.println("\nSUCCESS: Both methods yield matching results!");
        } else {
            System.out.println("\nFAILURE: Value discrepancy found between methods!");
        }
    }
}
