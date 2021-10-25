package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        FileReader fr = new FileReader("c:/data.txt");
    }

    public static void main(String[] args) {
        VeryComplexClass vcc = new VeryComplexClass();
        try {
            vcc.veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
