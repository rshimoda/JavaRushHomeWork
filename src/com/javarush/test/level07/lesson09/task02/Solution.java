package com.javarush.test.level07.lesson09.task02;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 5 слов в обратном порядке
Введи с клавиатуры 5 слов в список строк. Выведи их в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<String>();

        for (int i = 0; i < 5; ++i) words.add(reader.readLine());
        for (int i = words.size() - 1; i >= 0; i--) System.out.println(words.get(i));
    }
}
