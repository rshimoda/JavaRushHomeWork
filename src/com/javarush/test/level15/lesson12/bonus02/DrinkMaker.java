package com.javarush.test.level15.lesson12.bonus02;


public abstract class DrinkMaker {
    abstract void getRightCup();

    abstract void putIngredient();

    abstract void pour();

    protected void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
