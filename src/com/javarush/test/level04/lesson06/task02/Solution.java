package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNum1 = reader.readLine();
        String sNum2 = reader.readLine();
        String sNum3 = reader.readLine();
        String sNum4 = reader.readLine();
        int nNum1 = Integer.parseInt(sNum1);
        int nNum2 = Integer.parseInt(sNum2);
        int nNum3 = Integer.parseInt(sNum3);
        int nNum4 = Integer.parseInt(sNum4);
        System.out.println(max(nNum1, nNum2, nNum3, nNum4));
    }

    public static int max(int a, int b, int c, int d) {
        return max(max(a, b), max(c, d));

    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }

    }
}