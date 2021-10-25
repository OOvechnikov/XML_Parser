package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    private static final String COUNTRY = Country.RUSSIA;
    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "
                + Country.RUSSIA + ". Я несу "
                + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
