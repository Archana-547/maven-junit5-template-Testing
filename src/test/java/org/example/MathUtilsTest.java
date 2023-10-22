package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeAll
    static void setupAll() {
        System.out.println("Action before all test-once");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Action after all test-once");

    }

    @BeforeEach
    void setup() {
        mathUtils = new MathUtils();
        System.out.println("Before each");
    }


    @Test
    void testAddPositiveIntegers() {
        //MathUtils add = new MathUtils();
        int sum = mathUtils.add(5, 1);
        Assertions.assertEquals(6, sum);

    }

    @Test
    void testAddPositiveIntegerToZero() {
        //MathUtils add = new MathUtils();
        int sum = mathUtils.add(5, 1);
        Assertions.assertEquals(6, sum);
    }

    @Test
    void testAddNegativeIntegersToPositive() {
        //MathUtils add = new MathUtils();
        int sum = mathUtils.add(-5, 1);
        Assertions.assertEquals(-4, sum);
    }

    @Test
    void testAddLargeIntegers() {
        int result = mathUtils.add(Integer.MAX_VALUE, 1);
        Assertions.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    void testFirstArgumentIsLarger() {
        int result = mathUtils.findLarger(8, 2);
        Assertions.assertTrue(result == 8);
    }


    @Test
    void testSecondArgumentsIsLarger() {
        int result = mathUtils.findLarger(2, 8);
        Assertions.assertTrue(result == 8);

    }

    @Test
    void testBothArgumentsAreEqual() {
        int result = mathUtils.findLarger(8, 8);
        Assertions.assertTrue(result == 8);
    }

    @Test
    void testArgumentsIsGreater() {
        int result = mathUtils.findGreater(2, 8);
        Assertions.assertFalse(result == 8);
    }

    @Test
    void testDivide() {
        double result = mathUtils.divide(10.0, 2.0);
        assertEquals(5.0, result, 0.001);

    }

    @Test
    void testMultiply() {
        double result = mathUtils.multiply(3.5, 2.0);
        assertEquals(7.0, result, 0.001);

    }
//=====================Test using params=================//

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    void testAddPositiveIntegers(int num) {
        int sum = mathUtils.add(num, num);
        Assertions.assertEquals(2 * num, sum);
    }

    ;

    @ParameterizedTest
    @ValueSource(doubles = {2.0, 3.0, 5.0})
    void testSquare(double num) {
        double result = mathUtils.square(num);
        Assertions.assertEquals(num * num, result, 0.001);
    }


    //=============using csvsource annotations with 3  param==============//
    @ParameterizedTest
    //@CsvFileSource(resources = "/testdata.csv")
    @CsvSource({"1,1,2", "2,3,5", "10,-3, 7" })
    void testAddWithCsvFileSource(int a, int b, int expected) {
        MathUtils mathUtils = new MathUtils();
        int result = mathUtils.add(a, b);
        Assertions.assertEquals(expected, result);
    }


    @ParameterizedTest
    //@CsvFileSource(resources = "/testdata.csv")
    @CsvSource({"1,1,1", "2,3,6", "10, 3, 30" })
    void testMultiplyWithCsvFileSource(int num1,int num2, int expected) {
        MathUtils mathUtils = new MathUtils();
        double sum = mathUtils.multiply(num1, num2);
        assertEquals(expected, sum);
    }

}
