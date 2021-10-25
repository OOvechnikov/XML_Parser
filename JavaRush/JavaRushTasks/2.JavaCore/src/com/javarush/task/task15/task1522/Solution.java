package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void main(String[] args) {

    }

    public static Planet thePlanet;



    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String key = reader.readLine();
            if (Planet.SUN.equals(key)) {
                thePlanet = Sun.getInstance();
            } else if (Planet.EARTH.equals(key)) {
                thePlanet = Earth.getInstance();
            } else if (Planet.MOON.equals(key)) {
                thePlanet = Moon.getInstance();
            } else {
                thePlanet = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
