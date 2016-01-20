package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Сергей on 08.07.2014.
 */
public class Hippodrome {
    static ArrayList<Horse> horses = new ArrayList<Horse>();


    ArrayList<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public static void main(String[] args) {

        game = new Hippodrome();

        horses.add(new Horse("Betty", 3, 0));
        horses.add(new Horse("Charlie", 3, 0));
        horses.add(new Horse("Foxtrot", 3, 0));

    }
}
