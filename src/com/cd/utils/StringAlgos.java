package com.cd.utils;

import java.util.HashSet;

public class StringAlgos {
    /**
     * Determines if the provided input string contains only unique characters.
     * 
     * In order to do this, we need to:
     * 
     * <pre>
     * 1) Loop through each character of the word
     * 1.a) Check to see if we've already seen the character.
     * 1.a.1) If so, the return false.
     * 1.a.2) Otherwise, add it to the set
     * </pre>
     * 
     * @param input The input string to test.
     * @return True if the input string contains unique characters, and false otherwise.
     */
    public static Boolean containsUniqueCharacters(String input) throws IllegalArgumentException {
        // If the input is null, then throw an error.
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        // We want to use a set to keep track of characters we've already seen.
        var visited = new HashSet<Character>();

        // Loop through each character index of the word.
        for (var i = 0; i < input.length(); ++i) {
            // Store the character at index i.
            var character = input.charAt(i);

            // Check to see if we've already seen this character.
            if (visited.contains(character)) {
                // If so, then we know that we can return false.
                return false;
            }

            // Always add the character to the set.
            visited.add(character);
        }

        // If we've made it through the string, then we can safely say there are no duplicate
        // characters.
        return true;
    }

    /**
     * Encodes the provided word by compressing consecutive repeating characters.
     * 
     * ex: "aabaacccc" becomes "a2b1a2c4"
     * 
     * The process is as follows:
     * 
     * <pre>
     * 1) Move through each character in the string
     * 1.a) Check to see if the current character matches the last character we've seen.
     * 1.a.1) If so, then update our counter.
     * 1.a.2) If not, then append the last character and its count to the result. Reset 
     *     the counter and the last character to the current one.
     * 2) Add the final character and its count
     * to the result.
     * </pre>
     * 
     * @param input
     * @return
     */
    public static String encodeString(String input) {
        // If we are given a null string or an empty string, just return the input.
        if (input == null || input.length() == 0) {
            return input;
        }

        // We're going to store our result as we move through the input string.
        var result = "";

        // Initialize counter with 1 since we're starting with the first letter.
        var counter = 1;
        // We'll use this variable to keep track of the last character we've visited.
        var lastCharacter = input.charAt(0);

        // Loop though every character of the word, starting with the SECOND character.
        for (var i = 1; i < input.length(); ++i) {
            // Store the current character in a new variable.
            var currentCharacter = input.charAt(i);

            // Check to see if the current character matches the last one we saw.
            if (currentCharacter == lastCharacter) {
                // If it does, increment our counter.
                ++counter;
            } else {
                // If the character doesn't match, then we should update the result.
                result = result + lastCharacter + counter;

                // Let's reset the counter since we're changing the last character we've seen.
                counter = 1;
                lastCharacter = currentCharacter;
            }
        }

        // Before we leave, we need to add the last character to the result.
        result = result + lastCharacter + counter;

        return result;
    }

    /**
     * Returns the shuffled characters of the provided word.
     * 
     * Here's the approach:
     * 
     * <pre>
     * 1) Convert the string to a character array.
     * 2) Iterate through each character in the array. 
     * 2.a) Pick a random index between 0 and the array length.
     * 2.b) Swap the characters at the current index and the random one.
     * 3) Return a new string from the character array.
     * </pre>
     * 
     * @param word
     * @return
     */
    public static String shuffleString(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        // Convert the input string to a character array since strings are immutable.
        var charArray = input.toCharArray();

        // Move through each character in the array.
        for (var i = 0; i < charArray.length; ++i) {
            // Pick a random index in the array.
            var randomIndex = (int) Math.floor(Math.random() * charArray.length);

            // Swap the characters at i and the random index.
            swapCharacters(charArray, i, randomIndex);
        }

        // Return a new string from the shuffled character array.
        return new String(charArray);
    }

    /**
     * Swaps the characters in the provided character array.
     * 
     * @param charArray
     * @param i
     * @param j
     */
    private static void swapCharacters(char[] charArray, int i, int j) {
        Character temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}
