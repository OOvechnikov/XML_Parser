package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filename1 = args[1];
        String filename2 = args[2];
        FileInputStream inputStream = new FileInputStream(filename1);
        FileOutputStream outputStream = new FileOutputStream(filename2);
        if (!(args[0].equals("-e") || args[0].equals("-d"))) return;
        if (args[0].equals("-e")) {
            while (inputStream.available() > 0) {
                int b = inputStream.read() + 1;
                outputStream.write(b);
            }
        } else {
            while (inputStream.available() > 0) {
                int b = inputStream.read() - 1;
                outputStream.write(b);
            }
        }
        outputStream.close();
        inputStream.close();
    }

}
