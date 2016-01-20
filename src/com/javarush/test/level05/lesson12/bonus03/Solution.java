package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //int maximum = ;

        //напишите здесь ваш код
        int maxnum = Integer.parseInt(reader.readLine());
        if (maxnum <= 0) return;
        int val[] = new int[maxnum];
        for (int a = 0; a <= maxnum - 1; a++) {
            int var = Integer.parseInt(reader.readLine());
            val[a] = var;

        }
        for (int a = 1; a < val.length; a++)
            for (int b = val.length - 1; b >= a; b--) {
                if (val[b - 1] < val[b]) {
                    int t = val[b - 1];
                    val[b - 1] = val[b];
                    val[b] = t;
                }
            }


        System.out.println(val[0]);
    }
}
