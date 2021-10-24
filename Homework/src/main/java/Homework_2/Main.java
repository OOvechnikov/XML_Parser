package Homework_2;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Animal murka = new Cat("Мурка", random.nextInt(6) + 5);
        Animal sharik = new Dog("Шарик", random.nextInt(11) + 10);

        for (int i = 0; i < 50; i++) {
            if (random.nextInt(2) == 1) {
                murka.eat();
                sharik.eat();
            } else {
                murka.voice();
                sharik.voice();
            }
        }
        murka.printStatus();
        sharik.printStatus();
    }
}
