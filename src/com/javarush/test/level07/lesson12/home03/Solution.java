package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //Напишите тут ваш код
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(reader.readLine());

        maximum = nums[nums.length / 2];
        minimum = nums[nums.length / 2];

        for (int i = 0; i < nums.length; i++) {
            if (maximum < nums[i]) maximum = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (minimum > nums[i]) minimum = nums[i];
        }

        System.out.println(maximum + " " + minimum);
    }
}
