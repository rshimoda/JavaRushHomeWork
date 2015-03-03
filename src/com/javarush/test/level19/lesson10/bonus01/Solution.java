package com.javarush.test.level19.lesson10.bonus01;

import java.util.LinkedList;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {

    static LinkedList<Integer> primeNums = new LinkedList<Integer>();
    static {
        primeNums.add(2);

        for(int i = 3; i < 100000; i++)
        {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++)
                if (i%j == 0) { isPrime = false; break; }
            if(isPrime) primeNums.add(i);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int nums[][] = new int[n][m];

        //Input
        for(int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                nums[i][j] = scanner.nextInt();
        scanner.close();

        //Check-up
        for(int i = 0; i < n; i++) {
            boolean isLinePrime = true;
            boolean isColumPrime = true;

            for (int j = 0; j < m; j++)
            {
                if(!primeNums.contains(nums[i][j])) isLinePrime = false;
                if(j >= n) { isColumPrime = false; break; }
                if(!primeNums.contains(nums[j][i])) isColumPrime = false;
            }
            if(isLinePrime || isColumPrime) { System.out.println("0"); return; }
        }


        int min = Integer.MAX_VALUE;

        //Lines/Colums checker
        for(int i = 0; i < n; i++) {
            int counterLine = 0, counterCol = 0;
            for (int j = 0; j < m; j++) {
                int x = nums[i][j];
                while (!primeNums.contains(x)) { counterLine++; x++; }

                if(j >= n) break;
                x = nums[j][i];
                while (!primeNums.contains(x)) { counterCol++; x++; }
            }
            if(counterCol < counterLine) { if(counterCol < min ) min = counterCol; } else { if (counterLine < min) min = counterLine; }
        }

        System.out.println(min);
    }
}
