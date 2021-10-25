package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    private static final String COUNTRY = Country.BELARUS;
    @Override
    public int getCountOfEggsPerMonth() {
        return 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "
                + Country.BELARUS + ". Я несу "
                + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
