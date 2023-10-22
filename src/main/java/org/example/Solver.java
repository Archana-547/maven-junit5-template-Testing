package org.example;

public class Solver {

    public int solveQuadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            return 2; // Two real roots
        } else if (discriminant == 0) {
            return 1; // One real root
        } else {
            return 0; // No real roots
        }
    }
}