package tests;

import binarysearch.MyCollections;

import java.util.*;

public class MyCollectionsTest {

    public static void main(String[] args) {
        testMyCollections();
    }

    private static void testMyCollections() {
        System.out.println("Testing MyCollections...");

        // Testing binarySearch for List with natural order
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9);
        assert MyCollections.binarySearch(intList, 5) == 2;
        assert MyCollections.binarySearch(intList, 1) == 0;
        assert MyCollections.binarySearch(intList, 9) == 4;
        assert MyCollections.binarySearch(intList, 4) == -3;

        // Testing binarySearch for List with custom Comparator
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date");
        Comparator<String> reverseComparator = Comparator.reverseOrder();
        List<String> reverseSortedList = new ArrayList<>(stringList);
        reverseSortedList.sort(reverseComparator);
        assert MyCollections.binarySearch(reverseSortedList, "date", reverseComparator) == 0;
        assert MyCollections.binarySearch(reverseSortedList, "apple", reverseComparator) == 3;

        System.out.println("MyCollections tests passed!");
    }
}
