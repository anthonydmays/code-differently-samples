package com.cd.utils;

public class Console {
    public static void printIntro() {
        System.out.print("\033\143");
        System.out.println("""
                ****************
                * PROGRAM OUTPUT
                ****************
                        """);
    }

    public static void printOutro() {
        System.out.println();
    }
}
