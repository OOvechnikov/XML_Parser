package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];
        File file = new File(resultFileName);

        List<String> archList = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            archList.add(args[i]);
        }
        Collections.sort(archList);

        List<FileInputStream> fileInputStreamList = new ArrayList<>();

        for (int i = 0; i < archList.size(); i++) {
            FileInputStream fis = new FileInputStream(archList.get(i));
            fileInputStreamList.add(fis);
        }

        ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreamList)));

        while (zis.available() > 0) {
            ZipEntry zipEntry = zis.getNextEntry();
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            final int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            for (int readBytes; (readBytes = zis.read(buffer, 0, bufferSize)) > -1; ) {
                bos.write(buffer, 0, readBytes);
            }
            bos.flush();
            bos.close();
        }
        zis.close();
    }
}
