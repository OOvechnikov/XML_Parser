package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);

        String text = outputStream.toString().replaceAll("\r", "");
        String context = "JavaRush - курсы Java онлайн\n";
        StringBuilder result = new StringBuilder(text);
        int counter = 0, sbcounter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                counter++;
                if (counter % 2 == 0) {
                    result.insert(i + 1 + sbcounter * 29, context);
                    sbcounter++;
                }
            }
        }
        System.out.println(result.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
