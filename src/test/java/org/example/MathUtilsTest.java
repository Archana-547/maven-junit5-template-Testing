package org.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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


//=====================Test using params=================//

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    void testAddPositiveIntegers(int num) {
        int sum = mathUtils.add(num, num);
        Assertions.assertEquals(2 * num, sum);
    }


  }
