package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "", fileName2 = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fileReader = new FileReader(fileName1);
            FileWriter fileWriter = new FileWriter(fileName2)) {
            int counter = 0;
            int b;
            while (fileReader.ready()) {
                b = fileReader.read();
                counter++;
                if (counter % 2 == 0) {
                    fileWriter.write(b);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
