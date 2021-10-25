package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    static Random random = new Random();

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(8);
        byte[] b = new byte[8];
        while (true) {
            int randomCell = getRandomCell();
            if (b[randomCell] == 0) {
                b[randomCell] = getRandomNumber();
                break;
            }
        }
        while (true) {
            int randomCell = getRandomCell();
            if (b[randomCell] == 0) {
                b[randomCell] = getRandomLETTER();
                break;
            }
        }
        while (true) {
            int randomCell = getRandomCell();
            if (b[randomCell] == 0) {
                b[randomCell] = getRandomLetter();
                break;
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (b[i] == 0) {
                int r = random.nextInt(3);
                if (r == 0) {
                    b[i] = getRandomNumber();
                } else if (r == 1) {
                    b[i] = getRandomLETTER();
                } else {
                    b[i] = getRandomLetter();
                }
            }
        }

        baos.write(b);
        return baos;
    }

    private static int getRandomCell() {
        return random.nextInt(8);
    }
    private static byte getRandomNumber() {
        return (byte) (random.nextInt(10) + 48);
    }
    private static byte getRandomLETTER() {
        return (byte) (random.nextInt(25) + 65);
    }
    private static byte getRandomLetter() {
        return (byte) (random.nextInt(25) + 97);
    }
}
