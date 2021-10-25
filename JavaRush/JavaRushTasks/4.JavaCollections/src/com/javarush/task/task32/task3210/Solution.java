package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        long number = Long.parseLong(args[1]);
        String text = args[2];

        raf.seek(number);
        byte[] requiredText = text.getBytes();
        byte[] existText = new byte[text.length()];
        raf.read(existText, 0, text.length());
        raf.seek(raf.length());
        if (Arrays.equals(requiredText, existText)) {
            raf.write("true".getBytes());
        } else {
            raf.write("false".getBytes());
        }

    }
}
