package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String fileNameOne = "", fileNameTwo = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileNameOne = bufferedReader.readLine();
            fileNameTwo = bufferedReader.readLine();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileNameOne));
            String line = fileReader.readLine();
            while (line != null) {
                allLines.add(line);
                line = fileReader.readLine();
            }
            fileReader = new BufferedReader(new FileReader(fileNameTwo));
            line = fileReader.readLine();
            while (line != null) {
                forRemoveLines.add(line);
                line = fileReader.readLine();
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Solution solution = new Solution();
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

}
