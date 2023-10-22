package org.example;

public class SolverTest {
    public static void main(String[] args) {
        Solver solver = new Solver();

        // Example 1: Two real roots
        int roots1 = solver.solveQuadratic(1, -3, 2); // x^2 - 3x + 2 = 0
        System.out.println("Number of roots: " + roots1); // Output: 2

        // Example 2: One real root
        int roots2 = solver.solveQuadratic(1, -2, 1); // x^2 - 2x + 1 = 0
        System.out.println("Number of roots: " + roots2); // Output: 1

        // Example 3: No real roots
        int roots3 = solver.solveQuadratic(1, 2, 5); // x^2 + 2x + 5 = 0
        System.out.println("Number of roots: " + roots3); // Output: 0
    }
}

