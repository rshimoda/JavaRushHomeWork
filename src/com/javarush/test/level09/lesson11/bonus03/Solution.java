package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //Напишите тут ваш код
        List<Integer> listInt = new ArrayList<Integer>(); //Индексы чисел
        List<Integer> listStr = new ArrayList<Integer>(); //Индексы строк

        //Занести отдельно индексы чисел и строк
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) listInt.add(i);
            else listStr.add(i);
        }

        //Сортировка чисел
        for (int x = 0; x < listInt.size(); x++) {
            int y = listInt.size() - 1;
            for (; y > x; y--) {
                if (Integer.parseInt(array[listInt.get(y - 1)]) < Integer.parseInt(array[listInt.get(y)])) {
                    String s = array[listInt.get(y - 1)];
                    array[listInt.get(y - 1)] = array[listInt.get(y)];
                    array[listInt.get(y)] = s;
                }
            }
        }

        //Сортировка строк
        for (int x = 0; x < listStr.size(); x++) {
            int z = listStr.size() - 1;
            for (; z > x; z--) {
                if (isGreaterThen(array[listStr.get(z - 1)], array[listStr.get(z)])) {
                    String s = array[listStr.get(z - 1)];
                    array[listStr.get(z - 1)] = array[listStr.get(z)];
                    array[listStr.get(z)] = s;
                }
            }
        }
    }


    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThen(String a, String b) {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && c != '-') return false;
        }
        return true;
    }
}
