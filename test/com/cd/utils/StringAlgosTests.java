package test.com.cd.utils;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import org.junit.Test;
import com.cd.utils.StringAlgos;

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
        assertThrows("Excepted shuffleString to throw.", IllegalArgumentException.class,
                () -> StringAlgos.shuffleString(null));
    }

    @Test
    public void reverseString_reversesTheInput() {
        assertEquals("gnirts tset", StringAlgos.reverseString("test string"));
    }

    @Test
    public void reverseString_throwsOnNull() {
        assertThrows("Excepted reverseString to throw.", IllegalArgumentException.class,
                () -> StringAlgos.reverseString(null));
    }

    @Test
    public void encodeString_encodesTheInput() {
        assertEquals("a2b1a2c4", StringAlgos.encodeString("aabaacccc"));
    }

    @Test
    public void encodeString_encodesNull() {
        assertEquals(null, StringAlgos.encodeString(null));
    }
}
