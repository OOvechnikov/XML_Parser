package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));
        File file = new File("D:\\5.txt");
        try {
            FileInputStream inputStream = new FileInputStream("D:\\5.txt");
            FileOutputStream outputStream = new FileOutputStream("D:\\5.ser");
            ObjectInputStream in = new ObjectInputStream(inputStream);
            ObjectOutputStream out = new ObjectOutputStream(outputStream);

            Solution savedObject = new Solution(25);
            out.writeObject(savedObject);
            out.close();

            Solution loadedObject = (Solution) in.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
