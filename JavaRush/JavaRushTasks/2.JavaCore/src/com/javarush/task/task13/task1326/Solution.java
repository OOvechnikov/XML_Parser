package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        String fileName;
        FileInputStream fileInputStream = null;
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
//            fileName = "D:\\lines.txt";
            fileInputStream = new FileInputStream(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i;
            String line = "";
            while ((i = bufferedInputStream.read()) != -1) {

                if ((char) i == '\n' || (char) i == '\r') {
                    if (!line.isEmpty()) {
                        stringList.add(line);
                    }
                    line = "";
                    continue;
                }
                line += (char) i;
            }
            if (!line.isEmpty()) {
                stringList.add(line);
            }
            bufferedInputStream.close();
            for (String stringLine : stringList) {
                intList.add(Integer.parseInt(stringLine));
            }
            for (int j = 0; j < intList.size(); j++) {
                if (intList.get(j) % 2 != 0) {
                    intList.remove(j);
                    j--;
                }
            }
            Collections.sort(intList);
            for (Integer intLine : intList) {
                System.out.println(intLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
