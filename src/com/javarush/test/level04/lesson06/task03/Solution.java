package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        int num[] = new int[3];
        num[0] = max(nNum1, nNum2, nNum3);
        num[1] = mid(nNum1, nNum2, nNum3);
        num[2] = min(nNum1, nNum2, nNum3);

        for (int i = 0; i < num.length; ++i) System.out.print(num[i] + " ");
    }

    public static int min(int a, int b, int c) {
        int min = 0;
        if (a < b & a < c) min = a;
        else if (b < a & b < c) min = b;
        else if (c < a & c < b) min = c;
        return min;
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

    public static int max(int a, int b, int c) {
        int max = 0;
        if (a > b & a > c) max = a;
        else if (b > a & b > c) max = b;
        else if (c > a & c > b) max = c;
        return max;
    }

}