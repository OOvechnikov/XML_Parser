package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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
                newLine = changeSymbols(line);
                fileWriter.write(newLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String changeSymbols(String line) {
        StringBuilder newLine = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '.') {
                newLine.append('!');
                continue;
            }
            newLine.append(line.charAt(i));
        }
        return newLine.toString();
    }

}
