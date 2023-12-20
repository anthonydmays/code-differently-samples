package com.cd;

import com.cd.utils.Console;
import com.cd.utils.StringAlgos;

public class Session2 {
    public static void main(String[] args) {
        Console.printIntro();
        runProgram();
        Console.printOutro();
    }

    public static void runProgram() {
        System.out.println(String.format("Does \"%s\" equal the string %s? %s", "abc", "abc",
                StringAlgos.areEqual("abc", "abc")));

        System.out.println(String.format("Does \"%s\" equal the string %s? %s", "abc", "xyz",
                StringAlgos.areEqual("abc", "xyz")));

        System.out.println(String.format("Does \"%s\" contain only unique characters? %s", "abc",
                StringAlgos.containsUniqueCharacters("abc")));

        System.out.println(String.format("Does \"%s\" contain only unique characters? %s", "aaa",
                StringAlgos.containsUniqueCharacters("aaa")));

        System.out.println(String.format("Here's the phrase \"%s\" shuffled: \"%s\"",
                "Code Differently", StringAlgos.shuffleString("Code Differently")));

        System.out.println(String.format("Here's the phrase \"%s\" reversed: \"%s\"",
                "Code Differently", StringAlgos.reverseString("Code Differently")));

        System.out.println(String.format("Here's the encoded version of the string \"%s\": %s",
                "aaabccddddd", StringAlgos.encodeString("aaabccddddd")));

        System.out.println(String.format(
                "Here's the first index of the string \"%s\" in \"%s\": %s", "Different",
                "Code Differently", StringAlgos.indexOf("Code Differently", "Different")));
    }
}
