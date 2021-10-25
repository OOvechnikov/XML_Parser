package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

import java.util.Date;

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        double interrupt = 3.5;
        if (interrupt < (double) numSeconds) {
            Thread.sleep((long) (interrupt * 1000));
            clock.interrupt();
        }
        clock.join();
    }

    public static class RacingClock extends Thread {

        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            Thread thread = currentThread();
            for (int i = numSeconds; i > 0; i--) {
                System.out.print(numSeconds + " ");
                try {
                    Thread.sleep(1000);
                    numSeconds--;
                } catch (InterruptedException e) {
                    System.out.println("Прервано!");
                    return;
                }
            }
            System.out.print("Марш!");
        }
    }
}
