package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String fileName1 = "", fileName2 = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        try (BufferedReader file1Reader = new BufferedReader(new FileReader(fileName1));
            BufferedReader file2Reader = new BufferedReader(new FileReader(fileName2))) {
            while (file1Reader.ready()) {
                list1.add(file1Reader.readLine());
            }
            while (file2Reader.ready()) {
                list2.add(file2Reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String line1, line2;
        int counter1 = 0, counter2 = 0;

        while ((counter1 < list1.size()) && (counter2 < list2.size())) {
            line1 = list1.get(counter1);
            line2 = list2.get(counter2);
            if (line1.equals(line2)) {
                lines.add(new LineItem(Type.SAME, line1));
                counter1++;
                counter2++;
            } else if ((counter1 + 1 < list1.size()) && (list1.get(counter1 + 1).equals(line2))) {
                lines.add(new LineItem(Type.REMOVED, line1));
                counter1++;
            } else if ((counter2 + 1 < list2.size()) && (line1.equals(list2.get(counter2 + 1)))) {
                lines.add(new LineItem(Type.ADDED, line2));
                counter2++;
            }
        }
        while (counter1 < list1.size()) {
            lines.add(new LineItem(Type.REMOVED, list1.get(counter1)));
            counter1++;
        }
        while (counter2 < list2.size()) {
            lines.add(new LineItem(Type.ADDED, list2.get(counter2)));
            counter2++;
        }


        for (LineItem item : lines) {
            System.out.println(item.toString());
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        public String toString() {
            return type.toString() + " " + line;
        }
    }
}
