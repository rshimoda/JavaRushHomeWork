package com.javarush.test.level14.lesson06.home01;


public class UkrainianHen extends Hen implements Country {
    @Override
    int getCountOfEggsPerMonth() {
        return 36;
    }

    @Override
    String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.", Country.UKRAINE, getCountOfEggsPerMonth());
    }
}
