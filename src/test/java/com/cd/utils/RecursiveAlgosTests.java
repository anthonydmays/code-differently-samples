package com.cd.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RecursiveAlgosTests {
    @Test
    public void getNthFibonacci_works() {
        assertEquals(1, RecursiveAlgos.getNthFibonacci(1));
        assertEquals(1, RecursiveAlgos.getNthFibonacci(2));
        assertEquals(2, RecursiveAlgos.getNthFibonacci(3));
        assertEquals(3, RecursiveAlgos.getNthFibonacci(4));
        assertEquals(5, RecursiveAlgos.getNthFibonacci(5));
        assertEquals(8, RecursiveAlgos.getNthFibonacci(6));
    }

    @Test
    public void getNthFibonacciFaster_works() {
        assertEquals(1, RecursiveAlgos.getNthFibonacciFaster(1));
        assertEquals(1, RecursiveAlgos.getNthFibonacciFaster(2));
        assertEquals(2, RecursiveAlgos.getNthFibonacciFaster(3));
        assertEquals(3, RecursiveAlgos.getNthFibonacciFaster(4));
        assertEquals(5, RecursiveAlgos.getNthFibonacciFaster(5));
        assertEquals(8, RecursiveAlgos.getNthFibonacciFaster(6));
    }

    @Test
    public void binarySearch_findsValueInArray() {
        var array = new int[] {1, 4, 5};
        assertEquals(0, RecursiveAlgos.binarySearch(array, 0, 2, 1));
        assertEquals(1, RecursiveAlgos.binarySearch(array, 0, 2, 4));
        assertEquals(2, RecursiveAlgos.binarySearch(array, 0, 2, 5));
    }

    @Test
    public void binarySearch_doesntFindValueInArray() {
        var array = new int[] {1, 4, 5};
        assertEquals(-1, RecursiveAlgos.binarySearch(array, 0, 2, 6));
        assertEquals(-1, RecursiveAlgos.binarySearch(array, 0, 2, -1));
        assertEquals(-1, RecursiveAlgos.binarySearch(array, 0, 2, 3));
    }

    @Test
    public void getStringPermutations_works() {
        String[] permutations = RecursiveAlgos.getStringPermutations("abc");
        Arrays.sort(permutations);
        assertEquals("[abc, acb, bac, bca, cab, cba]", Arrays.toString(permutations));
        assertEquals("[z]", Arrays.toString(RecursiveAlgos.getStringPermutations("z")));
    }
}
