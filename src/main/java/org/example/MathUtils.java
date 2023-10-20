package org.example;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class MathUtils {

    public static int add(int a, int b) {

        return a + b;
    }


    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }

    // Method for multiplying floating point numbers
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Method for squaring a number
    public static double square(double num) {
        return num * num;
    }


    public static int findLarger(int c, int d) {
        return  (c > d) ? c : d;

    }

    public static int findGreater(int e, int f) {
        return (e - f);
    }
}


