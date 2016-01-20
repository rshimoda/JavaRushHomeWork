package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //Напишите тут ваш код

        for (int i = 0; i < array.length; i++)
            for (int z = array.length - 1; z > i; z--) {
                String t;
                if (Character.toLowerCase(array[z - 1].charAt(0)) > Character.toLowerCase(array[z].charAt(0))) {
                    t = array[z - 1];
                    array[z - 1] = array[z];
                    array[z] = t;
                }
                if (Character.toLowerCase(array[z - 1].charAt(0)) == Character.toLowerCase(array[z].charAt(0)))
                    if (isGreaterThen(array[z - 1], array[z])) {
                        String b = array[z - 1]; array[z - 1] = array[z]; array[z] = b;
                    }
            }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
