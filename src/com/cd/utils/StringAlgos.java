package com.cd.utils;

import java.util.HashSet;

public class StringAlgos {
    /**
     * Determines whether the two provided strings are equal. This is case-sensitive.
     * 
     * @param first
     * @param second
     * @return
     */
    public static boolean areEqual(String first, String second) {
        // If both strings are null, then we consider them to be equal.
        if (first == null && second == null) {
            return true;
        }

        // We know that both strings aren't null, but ONE of them could be. If so, then we know
        // they aren't equal.
        if (first == null || second == null) {
            return false;
        }

        // We now know that both strings aren't null. But if their length doesn't match, then we
        // know they are not equal.
        if (first.length() != second.length()) {
            return false;
        }

        // Now we need to compare the words character by character.
        for (var i = 0; i < first.length(); ++i) {
            // If we find two characters at the same position that don't match, then we can return
            // false.
            if (first.charAt(i) != second.charAt(i)) {
                return false;
            }
        }

        // If we've made it this far, then we know that the strings match.
        return true;
    }

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

        // We want to use a set to keep track of characters we've already seen. A set can only
        // contain unique items.
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
     * @param input The string to shuffle.
     * @return The shuffled string.
     */
    public static String shuffleString(String input) throws IllegalArgumentException {
        // Check yoself before you wreck yoself.
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        // Strings are immutable. Let's convert to a char array so we can move characters around.
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
     * Returns the input string with characters reversed.
     * 
     * Here's how we do it:
     * 
     * <pre>
     * 1) Move from the beginning of the array to the half way point
     * 2) As we move, swap characters with the back half of the array
     * 
     * ex: 
     * input = "Code Differently";
     * swap1 = "yode DifferentlC"; // swap index 0 and 15
     * swap2 = "ylde DifferentoC"; // swap index 1 and 14
     * swap3 = "ylte DifferendoC"; // swap index 2 and 13
     * swap4 = "yltn DiffereedoC"; // swap index 3 and 12
     * swap5 = "yltneDiffer edoC"; // swap index 4 and 13
     * ...
     * swap8 = "yltnereffiD edoC"; // swap index 7 and 8 (done!)
     * </pre>
     * 
     * @param input
     * @return
     * @throws IllegalArgumentException
     */
    public static String reverseString(String input) throws IllegalArgumentException {
        // Check yoself before you wreck yoself.
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null.");
        }

        // Strings are immutable. Let's convert to a char array so we can move characters around.
        var charArray = input.toCharArray();

        // Since we're swapping the first half of the string with the last half, we only need to
        // travel halfway through the length of the string.
        for (var i = 0; i < input.length() / 2; ++i) {
            // Compute the corresponding index from the back of the string.
            var j = input.length() - i - 1;

            // Swap the characters at index i and j.
            swapCharacters(charArray, i, j);
        }

        // Return the new string from the char array.
        return new String(charArray);
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
     * 1.a) Check to see if the current character matches the last character we have seen.
     * 1.a.1) If so, then update our counter.
     * 1.a.2) If not, then append the last character and its count to the result. Reset 
     *     the counter and the last character to the current one.
     * 2) Add the final character and its count
     * to the result.
     * </pre>
     * 
     * Tip: Not all loops start at 0 or end at length-1. Pay attention to what you need to do.
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
