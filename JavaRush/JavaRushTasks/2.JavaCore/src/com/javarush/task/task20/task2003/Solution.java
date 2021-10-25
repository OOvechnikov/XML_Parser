package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputStream.toString()));
        for (Map.Entry<String, String> line : runtimeStorage.entrySet()) {
            String line2 = line.getKey() + " = " + line.getValue();
            fileWriter.write(line2);
        }
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        List<String> file = new ArrayList<>();
        String fileName = inputStream.toString();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            file.add(fileReader.readLine());
        }
        fileReader.close();

        for (String line : file) {
            if (line.startsWith("#") || line.startsWith("!")) {
                continue;
            }
            String name = line.substring(0, findSymbol(line));
            String value = line.substring(findSymbol(line));
            int a;
        }

    }

    public static void main(String[] args) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             FileInputStream fos = new FileInputStream(reader.readLine())) {
//            load(fos);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String asd = "key\\ with\\ spa\\=ces = Это значение, доступное по ключу \"key with spaces\".";
        System.out.println(findSymbol(asd));

        System.out.println(runtimeStorage);
    }

    private static int findSymbol(String line) {
        String str = line;
        int symbol = line.indexOf("=");
        while (line.charAt(symbol - 1) == '\\') {
            line = line.substring(symbol + 1);
            symbol += line.indexOf("=") + 1;
        }
        String name = str.substring(0, symbol).trim();
        String value = str.substring(symbol + 1).trim();
        System.out.println(name);
        System.out.println(value);
        int a;
        return symbol;
    }

}
