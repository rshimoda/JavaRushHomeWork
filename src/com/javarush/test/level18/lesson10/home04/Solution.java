package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    static char table[][];
    static int m, n;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        n = Integer.parseInt(String.valueOf(f.charAt(0))); // считываем параметры длины массива
        m = Integer.parseInt(String.valueOf(f.charAt(2)));

        table = new char[n][m];

        for(int i = 0; i < n; i++)
            table[i] = reader.readLine().toCharArray();
        reader.close();

        findFree();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m - 1; j++)
                System.out.print(table[i][j]);
            System.out.println(table[i][m - 1]);
        }
    }

    public static void way(int s, int t)
    {
        if(table[s][t] == ' ') table[s][t] = '.';

        if(s > 0 && table[s - 1][t] == ' ') way(s - 1, t);
        if(t < m && table[s][t + 1] == ' ') way(s,t + 1);
        if(s < n && table[s + 1][t] == ' ') way(s + 1, t);
        if(t > 0 && table[s][t - 1] == ' ') way(s, t - 1);
    }

    public static void findFree() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if (table[i][j] == ' ')
                {
                    way(i, j);
                    return;
                }
    }
}
