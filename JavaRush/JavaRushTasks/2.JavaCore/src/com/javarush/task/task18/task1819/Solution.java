package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName1 = "";
        String fileName2 = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();

        try (BufferedReader readerFile1 = new BufferedReader(new FileReader(fileName1))) {
            String line = "";
            while (readerFile1.ready()) {
                line = readerFile1.readLine();
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader readerFile2 = new BufferedReader(new FileReader(fileName2));
            BufferedWriter writerFile1 = new BufferedWriter(new FileWriter(fileName1))) {
            String line = "";
            while (readerFile2.ready()) {
                line = readerFile2.readLine();
                writerFile1.write(line);
            }
            for (String listLine : list) {
                writerFile1.write(listLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
