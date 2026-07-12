package com.dsa.forecasting;

public class FinancialForecasting {

    /**
     * Calculates future value recursively based on a constant growth rate.
     * Formula: FV = PV * (1 + r)^n
     * 
     * @param presentValue The current value (PV)
     * @param growthRate The constant growth rate per period (r)
     * @param periods The number of periods/years (n)
     * @return The predicted future value (FV)
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base Case: 0 periods remaining means value hasn't changed from present value
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive Case: Calculate the value for periods - 1, and grow it for one more period
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    /**
     * Optimized Iterative Approach (linear time, constant space)
     * This avoids call stack overhead.
     * 
     * @param presentValue The current value (PV)
     * @param growthRate The constant growth rate per period (r)
     * @param periods The number of periods/years (n)
     * @return The predicted future value (FV)
     */
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }
}
