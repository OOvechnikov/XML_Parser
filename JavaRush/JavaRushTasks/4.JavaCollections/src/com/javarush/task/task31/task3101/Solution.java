package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
*/

public class Solution {
    private List<File> files = new ArrayList<>();

    public static void main(String[] args) {
        String directory = args[0];
        String resultFileAbsolutePath = args[1];
        File folder = new File(directory);
        File oldFile = new File(resultFileAbsolutePath);
        File newFile = new File(oldFile.getParent() + "/allFilesContent.txt");

        if (FileUtils.isExist(oldFile)) {
            FileUtils.renameFile(oldFile, newFile);
        }

        Solution solution = new Solution();
        solution.getFileList(folder);
        List<File> fileList = solution.files;
        fileList.sort(Comparator.comparing(File::getName));

        BufferedReader fileReader;
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(newFile));) {
            for (File file : fileList) {
                fileReader = new BufferedReader(new FileReader(file));
                while(fileReader.ready()) {
                    fileWriter.write(fileReader.readLine());
                }
                fileReader.close();
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getFileList(File parentDirectory) {
        for (File file : parentDirectory.listFiles()) {
            if (file.isDirectory()) {
                getFileList(file.getAbsoluteFile());
            }
            String fileName = file.getName();
            if (file.length() <= 50 && fileName.endsWith(".txt")) {
                files.add(file);
            }
        }
    }

}
