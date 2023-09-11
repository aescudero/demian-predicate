package com.demian.java.predicate;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

class DemianPredicate {

    @Test
    void test_isEvenNumbers_oldFashion() {
        System.out.println("Even numbers: ");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    @Test
    void test_isEvenNumbers() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Even numbers: ");
        for (int i = 0; i < 100; i++) {
            if (isEven.test(i)) {
                System.out.println(i);
            }
        }
    }

    @Test
    void test_isNotEvenNumbers_Negate() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Not Even numbers: ");
        for (int i = 0; i < 100; i++) {
            if (isEven.negate().test(i)) {
                System.out.println(i);
            }
        }
    }

    @Test
    void test_isEvenAndGreaterThanTwenty() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThanTwenty = n -> n > 20;
        System.out.println("Even numbers greater than twenty: ");
        for (int i = 0; i < 100; i++) {
            if (isEven.and(isGreaterThanTwenty).test(i)) {
                System.out.println(i);
            }
        }
    }

    @Test
    void test_isEvenAndGreaterThanTwenty2() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isMultipleOfNine = n -> n % 9 == 0;
        System.out.println("Even numbers greater than twenty: ");
        for (int i = 0; i < 100; i++) {
            if (isEven.or(isMultipleOfNine).test(i)) {
                System.out.println(i);
            }
        }
    }

    @Test
    void test_isEquals() {
        String test = "My base string";
        Predicate<String> stringComparator = Predicate.isEqual(test);

        Assertions.assertTrue(stringComparator.test("My base string"));
        Assertions.assertFalse(stringComparator.test("bad String"));
    }

    @Test
    void test_not() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isOdd = Predicate.not(isEven);
        Assertions.assertTrue(isOdd.test(3));
    }

    @Test
    void test_BiPredicate() {
        BiPredicate<Integer, String> biPredicate = (i, s) -> i > 10 || s.contains("test");
        Assertions.assertTrue(biPredicate.test(20, "DDDD"));
        Assertions.assertTrue(biPredicate.test(2, "test"));
    }

    @Test
    void test_LongPredicate() {
        LongPredicate longPredicate = l -> l > 100;
    }

    @Test
    void test_predicateWithStream() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> evenNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(isEven).toList();
        boolean allMatch = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).allMatch(isEven);
        boolean anyMatch = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).anyMatch(isEven);
        evenNumbers.forEach(System.out::println);
        System.out.println("All Match? " + allMatch);
        System.out.println("Any Match? " + anyMatch);
    }



}


