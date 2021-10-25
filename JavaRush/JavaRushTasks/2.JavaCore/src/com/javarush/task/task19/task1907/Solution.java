package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(fileName)) {
            String word = "";
            char c;
            int counter = 0;
            while (fileReader.ready()) {
                c = (char) fileReader.read();
                if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                    word += c;
                } else {
                    if (word.equals("world")) {
                        counter++;
                    }
                    word = "";
                }
            }
            System.out.println(counter);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
