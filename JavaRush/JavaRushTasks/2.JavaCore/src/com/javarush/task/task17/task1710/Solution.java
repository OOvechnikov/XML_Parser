package com.javarush.task.task17.task1710;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;
        if (args[0].equals("-c")) {
            if (args[2].equals("м")) {
                person = Person.createMale(args[1], formatter.parse(args[3]));
            } else {
                person = Person.createFemale(args[1], formatter.parse(args[3]));
            }
            allPeople.add(person);
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals("-i")) {
            System.out.println(allPeople.get(Integer.parseInt(args[1])).toString());
        } else if (args[0].equals("-u")) {
            int index = Integer.parseInt(args[1]);
            person = allPeople.get(index);
            person.setName(args[2]);
            person.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
            person.setBirthDate(formatter.parse(args[4]));
        } else if (args[0].equals("-d")) {
            int index = Integer.parseInt(args[1]);
            person = allPeople.get(index);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }
}
