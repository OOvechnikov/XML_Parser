package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
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

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {

            String line, newLine;
            while (fileReader.ready()) {
                line = fileReader.readLine();
                newLine = line.replaceAll("\\p{P}", "");
                fileWriter.write(newLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
