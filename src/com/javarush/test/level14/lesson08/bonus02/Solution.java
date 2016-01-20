package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(nod(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())));
    }

    public static int nod(int a, int b) {
        int nod = 1;
        for (int i = 1; i < (a < b ? a : b); i++) {
            if (a % i == 0 && b % i == 0) nod = i;

        }
        return nod;
    }
}
