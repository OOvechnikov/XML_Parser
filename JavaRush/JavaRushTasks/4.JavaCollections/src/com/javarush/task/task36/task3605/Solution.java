package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> set = new TreeSet<>();
        FileReader reader = new FileReader(args[0]);
        while (reader.ready()) {
            int i = reader.read();
            if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122)) {
                set.add(String.valueOf((char) i).toLowerCase());
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i == 4) break;
        }
    }
}
