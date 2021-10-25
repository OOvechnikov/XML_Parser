package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/

public class Solution {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        rbt.insert(5);
        rbt.insert(11);
        rbt.insert(6);
        rbt.insert(122);
        System.out.println(rbt);
    }
}
