package com.javarush.test.level14.lesson06.home01;


public class RussianHen extends Hen implements Country {
    @Override
    int getCountOfEggsPerMonth() {
        return 33;
    }

    @Override
    String getDescription() {
        return String.format(super.getDescription() + " Моя страна - %s. Я несу %s яиц в месяц.", Country.RUSSIA, getCountOfEggsPerMonth());
    }
}
