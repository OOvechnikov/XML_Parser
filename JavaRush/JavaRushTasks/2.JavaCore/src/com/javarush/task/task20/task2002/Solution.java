package com.javarush.task.task20.task2002;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("d:\\2.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User oleg = new User();
            oleg.setFirstName("Oleg");
            oleg.setLastName("Ovechnikov");
            oleg.setBirthDate(new Date(1990 - 1900, 0, 29));
            oleg.setMale(true);
            oleg.setCountry(User.Country.RUSSIA);

            javaRush.users.add(oleg);
            javaRush.users.add(oleg);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            for (User user : users) {
                outputStream.write(user.getFirstName().getBytes(StandardCharsets.UTF_8));
                outputStream.write(10);
                outputStream.write(user.getLastName().getBytes(StandardCharsets.UTF_8));
                outputStream.write(10);
                outputStream.write(String.valueOf(user.getBirthDate().getTime()).getBytes(StandardCharsets.UTF_8));
                outputStream.write(10);
                outputStream.write(user.isMale() ? "Yes".getBytes(StandardCharsets.UTF_8) : "No".getBytes(StandardCharsets.UTF_8));
                outputStream.write(10);
                outputStream.write(user.getCountry().getDisplayName().getBytes(StandardCharsets.UTF_8));
                outputStream.write(10);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            List<String> parseList = new ArrayList<>();
            while(inputStream.available() > 0) {
                char c = 0;
                String line = "";
                while(c != 10) {
                    c = (char) inputStream.read();
                    line += c;
                }
                parseList.add(line.substring(0, line.length() -1));
            }

            int countOfUsers = parseList.size() / 5;
            for (int i = 0; i < countOfUsers; i++) {
                User parsedUser = new User();
                parsedUser.setFirstName(parseList.get(0 + 5 * i));
                parsedUser.setLastName(parseList.get(1 + 5 * i));
                parsedUser.setBirthDate(new Date(Long.parseLong(parseList.get(2 + 5 * i))));
                parsedUser.setMale(parseList.get(3 + 5 * i).equals("Yes"));

                String country = parseList.get(4 + 5 * i);
                if (country.equals(User.Country.RUSSIA.getDisplayName())) {
                    parsedUser.setCountry(User.Country.RUSSIA);
                } else if (country.equals(User.Country.UKRAINE.getDisplayName())) {
                    parsedUser.setCountry(User.Country.UKRAINE);
                } else {
                    parsedUser.setCountry(User.Country.OTHER);
                }

                users.add(parsedUser);
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

    }
}
