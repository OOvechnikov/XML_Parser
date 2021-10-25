package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private boolean boolPartOfName = true;
    private boolean boolPartOfContent = true;
    private boolean boolMinSize  = true;
    private boolean boolMaxSize = true;
    private Set<Path> foundFiles1 = new HashSet<>();
    private List<Path> foundFiles = new ArrayList<>();
    private List<Integer> criteriaList = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if (criteriaList.isEmpty()) {
            foundFiles.add(file);
            return FileVisitResult.CONTINUE;
        }
        boolean passed = false;
        for (Integer criteria : criteriaList) {
            passed = false;
            if (criteria == 1) {
                passed = file.getFileName().toString().contains(partOfName);
            }
            if (criteria == 2) {
                byte[] find = partOfContent.getBytes();
                passed = bytesFounder(content, find);
            }
            if (criteria == 3) passed = content.length > minSize;
            if (criteria == 4) passed = content.length < maxSize;
            if (!passed) break;
        }

        if (passed) {
            foundFiles.add(file);
        }
        return FileVisitResult.CONTINUE;

    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        criteriaList.add(1);
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        criteriaList.add(2);
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        criteriaList.add(3);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        criteriaList.add(4);
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    private boolean bytesFounder(byte[] source, byte[] search) {
        boolean find = false;
        for (int i = 0; i <= (source.length - search.length); i++) {
            if (source[i] == search[0]) {
                find = true;
                for (int j = 0; j < search.length; j++) {
                    if (source[i + j] != search[j]) {
                        find = false;
                        break;
                    }
                }
            }
            if (find) {
                break;
            }
        }
        return find;
    }

    private static class PartOfName {
        String source, partOfName;

        PartOfName(String source, String partOfName) {
            this.source = source;
            this.partOfName = partOfName;
        }

        private boolean isContain(String source, String partOfName) {
            return source.contains(partOfName);
        }

    }

}
