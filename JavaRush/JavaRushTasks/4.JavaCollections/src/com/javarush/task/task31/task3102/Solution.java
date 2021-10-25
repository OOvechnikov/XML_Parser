package com.javarush.task.task31.task3102;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList<>();
        File rootFolder = new File(root);
        Queue<File> queue = new LinkedList<>(Arrays.asList(rootFolder.listFiles()));
        while(!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                queue.addAll(Arrays.asList(file.listFiles()));
            } else {
                fileTree.add(file.getAbsolutePath());
            }
        }
        return fileTree;
    }

    private static List<String> fileTreeUsingRecursion = new ArrayList<>();

    public static void getFileTreeUsingRecursion(String root) {
        File rootFolder = new File(root);
        for (File file : rootFolder.listFiles()) {
            if (file.isDirectory()) {
                getFileTreeUsingRecursion(file.getAbsolutePath());
            } else {
                fileTreeUsingRecursion.add(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        try {
            long a = System.currentTimeMillis();
            List<String> fileTree = getFileTree("D:\\games");
            PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\2.txt"));
            for (String line : fileTree) {
                printWriter.println(line);
            }
            printWriter.close();
            System.out.println("Список файлов составлен с помощью очереди за " + (System.currentTimeMillis() - a) + " ms");

            long b = System.currentTimeMillis();
            getFileTreeUsingRecursion("D:\\games");
            printWriter = new PrintWriter(new FileWriter("D:\\3.txt"));
            for (String line : fileTreeUsingRecursion) {
                printWriter.println(line);
            }
            printWriter.close();
            System.out.println("Список файлов составлен с помощью рекурсии " + (System.currentTimeMillis() - b) + " ms");

            Collections.sort(fileTree);
            Collections.sort(fileTreeUsingRecursion);
            System.out.println("Списки вообще одинаковые? " + fileTree.equals(fileTreeUsingRecursion));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
