package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:/2.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringWriter writer = new StringWriter();
            String line;
            while(br.ready()) {
                line = br.readLine();
                writer.write(line);
            }
            br.close();
            return writer;
        }
        return new StringWriter();
    }
}
