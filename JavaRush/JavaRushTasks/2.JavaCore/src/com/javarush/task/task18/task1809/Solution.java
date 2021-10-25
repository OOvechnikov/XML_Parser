package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileNameOne);
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameTwo);
        byte[] buffer = new byte[1000];

        while (fileInputStream.available() > 0) {
            int count = fileInputStream.read(buffer);
            fileOutputStream.write(buffer, 0, count);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
