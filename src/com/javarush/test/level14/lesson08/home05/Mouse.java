package com.javarush.test.level14.lesson08.home05;

/**
 * Created by User on 02.08.2014.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
