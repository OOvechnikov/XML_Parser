package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    //start here - начни тут

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        Person person;
        int index;
        switch (args[0]) {
            case ("-c") : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 3) {
                        if (args[i + 1].equals("м")) {
                            person = Person.createMale(args[i], formatter.parse(args[i + 2]));
                        } else {
                            person = Person.createFemale(args[i], formatter.parse(args[i + 2]));
                        }
                        allPeople.add(person);
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            }
            case ("-i") : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        index = Integer.parseInt(args[i]);
                        System.out.println(allPeople.get(index).toString());
                    }
                    break;
                }
            }
            case ("-u") : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i = i + 4) {
                        index = Integer.parseInt(args[i]);
                        person = allPeople.get(index);
                        person.setName(args[i + 1]);
                        person.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(formatter.parse(args[i + 3]));
                    }
                    break;
                }
            }
            case ("-d") : {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        index = Integer.parseInt(args[i]);
                        person = allPeople.get(index);
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                    break;
                }
            }
        }
    }
}
