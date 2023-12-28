package com.cd.utils;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class StringAlgosTests {
    @Test
    public void areEqual_confirmsEqualStrings() {
        assumeTrue(StringAlgos.areEqual("abc", "abc"));
    }

    @Test
    public void areEqual_confirmsNullEqualStrings() {
        assumeTrue(StringAlgos.areEqual(null, null));
    }

    @Test
    public void areEqual_rejectsUnequalStrings() {
        assumeFalse(StringAlgos.areEqual("abc", "xyz"));
        assumeFalse(StringAlgos.areEqual(null, "xyz"));
        assumeFalse(StringAlgos.areEqual("abc", null));
        assumeFalse(StringAlgos.areEqual("abc", "ABC"));
        assumeFalse(StringAlgos.areEqual("first", "second"));
    }

    @Test
    public void containsUniqueCharacters_confirmsUniqueCharacterStrings() {
        assumeTrue(StringAlgos.containsUniqueCharacters(""));
        assumeTrue(StringAlgos.containsUniqueCharacters("a"));
        assumeTrue(StringAlgos.containsUniqueCharacters("abc"));
    }

    @Test
    public void containsUniqueCharacters_rejectsDupeCharacterStrings() {
        assumeFalse(StringAlgos.containsUniqueCharacters("aa"));
        assumeFalse(StringAlgos.containsUniqueCharacters("abbc"));
        assumeFalse(StringAlgos.containsUniqueCharacters("aaac"));
    }

    @Test
    public void containsUniqueCharacters_throwsOnNullArgumnts() {
        assertThrows(IllegalArgumentException.class,
                () -> StringAlgos.containsUniqueCharacters(null),
                "Excepted containsUniqueCharacters to throw.");
    }

    @Test
    public void shuffleString_shufflesInput() {
        var input = "some string";
        var shuffled = StringAlgos.shuffleString(input);

        // The strings shouldn't match each other.
        assertNotEquals(input, shuffled);

        var inputCharArray = input.toCharArray();
        Arrays.sort(inputCharArray);

        var shuffledCharArray = shuffled.toCharArray();
        Arrays.sort(shuffledCharArray);

        // The strings should still contain the same character frequencies.
        assertArrayEquals(inputCharArray, shuffledCharArray);
    }

    @Test
    public void shuffleString_throwsOnNull() {
        assertThrows(IllegalArgumentException.class, () -> StringAlgos.shuffleString(null),
                "Excepted shuffleString to throw.");
    }

    @Test
    public void reverseString_reversesTheInput() {
        assertEquals("gnirts tset", StringAlgos.reverseString("test string"));
    }

    @Test
    public void reverseString_throwsOnNull() {
        assertThrows(IllegalArgumentException.class, () -> StringAlgos.reverseString(null),
                "Excepted reverseString to throw.");
    }

    @Test
    public void indexOf_findsSubstring() {
        assertEquals(3, StringAlgos.indexOf("paydirt", "dirt"));
        assertEquals(0, StringAlgos.indexOf("test", "test"));
        assertEquals(6, StringAlgos.indexOf("fuzzy Bunny", "Bun"));
        assertEquals(11, StringAlgos.indexOf("don't bite tsetse", "tse"));
    }

    @Test
    public void encodeString_encodesTheInput() {
        assertEquals("a2b1a2c4", StringAlgos.encodeString("aabaacccc"));
    }

    @Test
    public void encodeString_encodesNull() {
        assertEquals(null, StringAlgos.encodeString(null));
    }

    @Test
    public void indexOf_terminatesCorectly() {
        assertEquals(-1, StringAlgos.indexOf("paydirt", "money"));
        assertEquals(-1, StringAlgos.indexOf("short", "longer"));
        assertEquals(-1, StringAlgos.indexOf("ABC", "abc"));
        assertEquals(-1, StringAlgos.indexOf("ABC", null));
        assertEquals(-1, StringAlgos.indexOf("ABC", ""));
    }

    @Test
    public void indexOf_throwsOnNullInput() {
        assertThrows(IllegalArgumentException.class, () -> StringAlgos.indexOf(null, "test"),
                "Excepted indexOf to throw.");
    }
}
