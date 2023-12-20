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
        System.out.println(String.format("Does \"%s\" contain only unique characters? %s", "abc",
                StringAlgos.containsUniqueCharacters("abc")));

        System.out.println(String.format("Does \"%s\" contain only unique characters? %s", "aaa",
                StringAlgos.containsUniqueCharacters("aaa")));

        System.out.println(String.format("Here's the encoded version of the string \"%s\": %s",
                "aaabccddddd", StringAlgos.encodeString("aaabccddddd")));

        System.out.println(String.format("Here's the phrase \"%s\" shuffled: \"%s\"",
                "Code Differently", StringAlgos.shuffleString("Code Differently")));
    }
}
