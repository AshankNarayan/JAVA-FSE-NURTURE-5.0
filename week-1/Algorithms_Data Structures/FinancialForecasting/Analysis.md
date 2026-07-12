# Financial Forecasting Analysis

## 1. Concept of Recursion

### What is Recursion?
Recursion is a programming technique where a method calls itself directly or indirectly to solve a problem. It solves a larger problem by breaking it down into smaller subproblems of the same nature.

Every recursive algorithm requires two key components:
1. **Base Case:** The condition under which the recursion stops. Without a base case, recursion runs infinitely and leads to a `StackOverflowError`.
2. **Recursive Step:** The part where the method calls itself with a modified, simpler version of the original input, moving closer to the base case.

### How it Simplifies Problems
- **Natural Representation:** Problems like tree traversals, factorials, the Fibonacci sequence, and directories are naturally recursive. Implementing them recursively mirrors their mathematical or structural definitions.
- **Cleaner Code:** It eliminates the need for complex state tracking and loop management variables, making the code shorter and easier to read.

---

## 2. Complexity Analysis of the Recursive Algorithm

For a prediction horizon of $N$ periods (years):

- **Time Complexity:** $O(N)$
  - Each call to `calculateFutureValue` does $O(1)$ constant time operations (multiplication and base case check) and spawns exactly **one** recursive call. Thus, there are a total of $N + 1$ calls, which scales linearly.
- **Space Complexity:** $O(N)$
  - Because each method call is placed on the JVM call stack, $N$ nested calls will occupy $N$ stack frames. This is a potential risk for high values of $N$ because it can trigger a `StackOverflowError`.

---

## 3. Optimizing the Recursive Solution

Although the time complexity of this specific simple recursion is already linear $O(N)$, we can optimize it in terms of both space/overhead and redundant computations:

### A. Iterative Approach (Preferred)
Converting the recursion to an iterative loop changes the space complexity from $O(N)$ to $O(1)$ since it executes inside a single stack frame.
```java
public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
    double futureValue = presentValue;
    for (int i = 0; i < periods; i++) {
        futureValue *= (1 + growthRate);
    }
    return futureValue;
}
```

### B. Memoization / Dynamic Programming
If the recursive function had overlapping subproblems (like computing complex branching growth paths or Fibonacci numbers), we could cache the results of previous calculations in a map or array (memoization). This avoids repeating identical calculations, reducing exponential $O(2^N)$ time complexity down to linear $O(N)$.

### C. Direct Mathematical Formula
Since this is a simple geometric progression, we can calculate the future value directly in $O(\log N)$ time using the power function:
```java
public static double calculateFutureValueFormula(double presentValue, double growthRate, int periods) {
    return presentValue * Math.pow(1 + growthRate, periods);
}
```
This is the most optimized solution because it avoids loops and recursion entirely.
