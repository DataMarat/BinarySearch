package tests;

import binarysearch.MyArrays;

import java.util.*;

public class MyArraysTest {

    public static void main(String[] args) {
        testMyArrays();
    }

    private static void testMyArrays() {
        System.out.println("Testing MyArrays...");

        // Testing binarySearch for int array
        int[] intArray = {1, 3, 5, 7, 9};
        assert MyArrays.binarySearch(intArray, 5) == 2;
        assert MyArrays.binarySearch(intArray, 1) == 0;
        assert MyArrays.binarySearch(intArray, 9) == 4;
        assert MyArrays.binarySearch(intArray, 4) == -3;

        // Testing binarySearch with range for int array
        assert MyArrays.binarySearch(intArray, 1, 3, 5) == 2;
        assert MyArrays.binarySearch(intArray, 1, 3, 7) == -3;

        // Testing binarySearch for byte array
        byte[] byteArray = {10, 20, 30, 40, 50};
        assert MyArrays.binarySearch(byteArray, (byte) 30) == 2;
        assert MyArrays.binarySearch(byteArray, (byte) 10) == 0;
        assert MyArrays.binarySearch(byteArray, (byte) 15) == -2;

        // Testing binarySearch for char array
        char[] charArray = {'a', 'b', 'c', 'd'};
        assert MyArrays.binarySearch(charArray, 'c') == 2;
        assert MyArrays.binarySearch(charArray, 'a') == 0;
        assert MyArrays.binarySearch(charArray, 'e') == -5;

        // Testing binarySearch for double array
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        assert MyArrays.binarySearch(doubleArray, 3.3) == 2;
        assert MyArrays.binarySearch(doubleArray, 1.1) == 0;
        assert MyArrays.binarySearch(doubleArray, 5.5) == -5;

        // Testing binarySearch for float array
        float[] floatArray = {1.0f, 2.0f, 3.0f, 4.0f};
        assert MyArrays.binarySearch(floatArray, 3.0f) == 2;
        assert MyArrays.binarySearch(floatArray, 1.0f) == 0;
        assert MyArrays.binarySearch(floatArray, 5.0f) == -5;

        // Testing binarySearch for long array
        long[] longArray = {100L, 200L, 300L, 400L};
        assert MyArrays.binarySearch(longArray, 300L) == 2;
        assert MyArrays.binarySearch(longArray, 100L) == 0;
        assert MyArrays.binarySearch(longArray, 500L) == -5;

        // Testing binarySearch for short array
        short[] shortArray = {10, 20, 30, 40};
        assert MyArrays.binarySearch(shortArray, (short) 30) == 2;
        assert MyArrays.binarySearch(shortArray, (short) 10) == 0;
        assert MyArrays.binarySearch(shortArray, (short) 50) == -5;

        // Testing binarySearch for generic objects with Comparable
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        assert MyArrays.binarySearch(stringArray, "cherry") == 2;
        assert MyArrays.binarySearch(stringArray, "apple") == 0;
        assert MyArrays.binarySearch(stringArray, "fig") == -5;

        // Testing binarySearch for generic objects with Comparator
        String[] customArray = {"apple", "banana", "cherry", "date"};
        Comparator<String> reverseComparator = Comparator.reverseOrder();
        Arrays.sort(customArray, reverseComparator);
        assert MyArrays.binarySearch(customArray, "date", reverseComparator) == 0;
        assert MyArrays.binarySearch(customArray, "apple", reverseComparator) == 3;

        System.out.println("MyArrays tests passed!");
    }
}
