package com.javarush.task.task20.task2001;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("d:\\2.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            outputStream.write(name.getBytes());
            outputStream.write(10);

            String isAssetsPresent = !assets.isEmpty() ? "Yes" : "No" ;
            outputStream.write(isAssetsPresent.getBytes());
            outputStream.write(10);
            if (isAssetsPresent.equals("Yes")) {
                for (Asset asset : assets) {
                    String str = asset.getName() + " " + asset.getPrice();
                    outputStream.write(str.getBytes(StandardCharsets.UTF_8));
                    outputStream.write(10);
                }
            }

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            List<String> parseList = new ArrayList<>();
            while(inputStream.available() > 0) {
                int b = 0;
                String line = "";
                while(b != 10) {
                    b = inputStream.read();
                    line += (char) b;
                }
                line = line.substring(0, line.length() - 1);
                parseList.add(line);
            }
            name = parseList.get(0);
            if (parseList.get(1).equals("Yes")) {
                for (int i = 2; i < parseList.size(); i++) {
                    String[] array = parseList.get(i).split(" ");
                    assets.add(new Asset(array[0], Double.parseDouble(array[1])));
                }
            }
        }

    }
}
