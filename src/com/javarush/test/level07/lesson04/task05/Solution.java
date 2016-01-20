package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution {
    final static int ARRAY_SIZE = 20; // Размер большого массива. Должен быть четным >= 2

    public static void main(String[] args) throws Exception {
        int[] bigArray = new int[ARRAY_SIZE];
        int[] firstSmallArray = new int[ARRAY_SIZE / 2];
        int[] secondSmallArray = new int[ARRAY_SIZE / 2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = Integer.parseInt(br.readLine());
            if (i < ARRAY_SIZE / 2) {
                firstSmallArray[i] = bigArray[i];
            } else {
                secondSmallArray[i - ARRAY_SIZE / 2] = bigArray[i];
            }
        }

        for (int n : secondSmallArray) {
            System.out.println(n);
        }
    }
}
