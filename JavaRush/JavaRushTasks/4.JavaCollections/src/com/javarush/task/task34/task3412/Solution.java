package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug("asd");
    }

    public static void main(String[] args) {
    }

    public void calculateAndSetValue3(long value) {
        logger.trace("начинаем считать");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("Сменили значение value1 на " + value1);
        } else {
            value1 = (int) value;
            logger.debug("Сменили значение value1 на " + value1);
        }
    }

    public void printString() {
        if (value2 != null) {
            System.out.println(value2.length());
        }
        logger.trace("распечатали value2");
    }

    public void printDateAsLong() {
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
        logger.trace("распечатали value3");
    }

    public void divide(int number1, int number2) {
        logger.trace("Делим");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Ошибка");
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("Сменили значение value1 на " + value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("Сменили значение value2 на " + value2);
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("Сменили значение value3 на " + value3);
    }
}
