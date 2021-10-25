package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {
    private static final String COUNTRY = Country.MOLDOVA;
    @Override
    public int getCountOfEggsPerMonth() {
        return 30;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - "
                + Country.MOLDOVA + ". Я несу "
                + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
