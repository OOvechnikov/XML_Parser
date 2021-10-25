package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
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

            String line = "", lineToWrite = "";
            int currNumber;
            while (fileReader.ready()) {
                line = fileReader.readLine();
                String[] array = line.split(" ");
                for (String block : array) {
                    try {
                        currNumber = Integer.parseInt(block);
                        lineToWrite += block + " ";
                    } catch (NumberFormatException e) {
                        System.out.println(block + " - не число");
                    }
                }
                fileWriter.write(lineToWrite.trim());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
