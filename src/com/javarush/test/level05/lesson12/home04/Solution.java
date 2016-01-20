package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 12 2012".
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {

    public static void main(String[] args) {
        // Make a new Date object. It will be initialized to the current time.
        Date now = new Date();

        DateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        String s = formatter.format(now);
        System.out.println(s);
    }
}
