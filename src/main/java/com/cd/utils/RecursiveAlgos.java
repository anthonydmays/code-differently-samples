package com.cd.utils;

import java.util.ArrayList;

public class RecursiveAlgos {

    /**
     * Calculates the nth Fibonacci number using the classic recursive approach. Learn more about
     * the Fibonnaci sequence at https://en.wikipedia.org/wiki/Fibonacci_sequence.
     * 
     * @param n The nth Fibonacci value to compute
     * @return The value
     */
    public static int getNthFibonacci(int n) {
        // Handle the base case where the first two numbers in the sequence (0 and 1).
        if (n < 2) {
            return n;
        }

        // Handle the recursive step. The Fibonacci recursive function is
        // F(n) = F(n - 1) + F(n - 2).
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }

    /**
     * Finds the index of the provided value in the given array between the low and high indices.
     * 
     * @param array The array to search
     * @param low The low index to start searching
     * @param high The high index to end searching
     * @param value The value to look for
     * @return The index of the value in the array if found, otherwise -1.
     */
    public static int binarySearch(int[] array, int low, int high, int value) {
        // Base case: if low is greater than high, then return -1.
        if (low > high) {
            return -1;
        }

        // Handle recursive: Compare the provided value to the "middle" value. If they don't match,
        // go right or left if the value we're looking for is greater than or less than the pivot
        // value, respectively.
        int pivot = (low + high) / 2;
        if (value == array[pivot]) {
            return pivot;
        } else if (value < array[pivot]) {
            return binarySearch(array, low, pivot - 1, value);
        } else {
            return binarySearch(array, pivot + 1, high, value);
        }
    }

    /**
     * Calculates all the permutations of the provided string value.
     * 
     * <pre>
     * Example: If given the string "abc", the method will return an array of:
     * 
     * ["abc", "acb", "bac", "bca", "cab", "cba"]
     * 
     * Note that the order of the returned strings are not guaranteed.
     * </pre>
     * 
     * @param value The string to permute.
     * @return
     * @throws Exception
     */
    public static String[] getStringPermutations(String value) {
        // Need to do some prep before calling the actual method. Turn the string into an array of
        // characters and create an `ArrayList` to store our answers.
        var chars = value.toCharArray();
        var answers = new ArrayList<String>();

        // Compute all the permutations starting from the beginning of the char array.
        getCharacterPermutations(chars, 0, answers);

        // Convert the `ArrayList` to a regular array.
        return answers.toArray(new String[answers.size()]);
    }

    /**
     * Computes remaining permutations of the string represented by the given character array and
     * starting at the specified index.
     * 
     * @param chars An array of characters representing a string
     * @param start The starting index
     * @param answers The list to use for storing answers.
     */
    private static void getCharacterPermutations(char[] chars, int start,
            ArrayList<String> answers) {
        // The base case: if we've reached the last character, then we've found the newest string
        // permutation and can add it to the answers.
        if (start == chars.length - 1) {
            answers.add(new String(chars));
            return;
        }

        // Recursive case: We're going to call the method recursively after swapping each character
        // with the starting index. After the recursive call, we have to swap the character back in
        // place.
        for (int i = start; i < chars.length; ++i) {
            swap(chars, start, i);
            getCharacterPermutations(chars, start + 1, answers);
            swap(chars, start, i);
        }
    }

    /**
     * Swaps the character in the array at index <code>i</code> with the one at index
     * <code>j</code>.
     * 
     * @param array
     * @param i
     * @param j
     */
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
