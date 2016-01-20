package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.util.Collections.sort;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));

        String line = null;
        while ((line = reader1.readLine()) != null) {
            String[] ws = line.trim().split("\\s");

            for (String s : ws) {
                if (checkString(s) && Integer.parseInt(s) % 2 == 0) {
                    list.add(Integer.parseInt(s));
                }
            }
        }
        sort(list);
        for (Integer i : list) {
            if (i % 2 == 0)
                System.out.println(i);
        }

    }

    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
