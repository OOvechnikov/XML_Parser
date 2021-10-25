package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object date = new Date();
        Integer dateInt = (Integer) date;
    }

    public void methodThrowsNullPointerException() {
        Date date = new Date();
        date.after(null);
    }

    public static void main(String[] args) {

    }
}
