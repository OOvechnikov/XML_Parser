package Homework_2;

public abstract class Animal {
    private final String name;
    private final String sound;
    private final int minWeight;
    private final int maxWeight;

    private int weight;

    private boolean isSleeping = false;
    private boolean isAlive = true;

    public Animal(String name, String sound, int weight, int minWeight, int maxWeight) {
        this.name = name;
        this.sound = sound;
        this.weight = weight;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }



    public void voice() {
        if (!isSleeping && isAlive) {
            System.out.println(sound);
            weight--;
            if (weight < minWeight) {
                isAlive = false;
                System.out.println(name + " умер(ла) :(");
            }
        } else {
            System.out.println(name + " умер(ла) :(");
        }
    }

    public void eat() {
        if (isAlive) {
            System.out.println(name + " ест");
            this.isSleeping = false;
            weight++;
            if (weight > maxWeight) {
                isAlive = false;
                System.out.println(name + " умер(ла) :(");
            }
        } else
            System.out.println(name + " умер(ла) :(");
    }

    public void printStatus() {
        String alive = isAlive ? "жив(а)" : "мертв(а)";
        System.out.println(name + ": " + alive + ", вес:" + weight);
    }

}
