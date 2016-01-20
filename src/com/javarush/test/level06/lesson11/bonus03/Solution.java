package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Напишите тут ваш код
        int nums[] = new int[5];

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

        for (int a = 1; a < nums.length; a++)
            for (int b = nums.length - 1; b >= a; b--) {
                if (nums[b - 1] > nums[b]) {
                    int t = 0;
                    t = nums[b - 1];
                    nums[b - 1] = nums[b];
                    nums[b] = t;
                }
            }
        for (int x = 0; x < nums.length; ++x) System.out.println(nums[x]);


    }
}
