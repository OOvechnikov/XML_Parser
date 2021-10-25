package com.javarush.task.jdk13.task08.task0818;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* 
Налоговая и зарплаты
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Random random = new Random();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), random.nextInt(1000));
        }
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Map<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() < 500) {
                copy.remove(pair.getKey());
            }
        }
        map.clear();
        map.putAll(copy);
    }

    public static void main(String[] args) {

    }
}