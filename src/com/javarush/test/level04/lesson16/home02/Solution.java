package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
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

        int nNum1 = Integer.parseInt(sNum1);
        int nNum2 = Integer.parseInt(sNum2);
        int nNum3 = Integer.parseInt(sNum3);

        System.out.print(mid(nNum1, nNum2, nNum3));

    }


    public static int mid(int a, int b, int c) {
        int mid = 0;
        if ((a < b & a > c)) mid = a;
        else if (a < c & a > b) mid = a;
        if (a < b & b < c) mid = b;
        else if (b > c & a > b) mid = b;
        if (c < b & a < c) mid = c;
        else if (a > c & c > b) mid = c;
        return mid;

    }

}