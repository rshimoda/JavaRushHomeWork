package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import com.javarush.test.level19.lesson10.bonus02.FileConsoleWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static char table[][];
    static int m,n;
    public static void main(String[] args) throws IOException
    {/*
        ArrayList<String> strings = new ArrayList<String>();

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (true)
        {
            String line = bufferedReader.readLine();
            if (line == null) break;
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++)
                if (words[i].length() > 6) { strings.add(words[i]); strings.add(","); }
        }
        bufferedReader.close();
        fileReader.close();

        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        strings.remove(strings.size() - 1);
        for (String x : strings)
        {
            bufferedWriter.write(x);
        }
        bufferedWriter.close();
        fileWriter.close();*/
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        table = new char[n][m];

        for (int i = 0; i < n; i++)
        {
            table[i] = scanner.nextLine().toCharArray();
        }
        scanner.close();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (table[i][j] == ' ') { way(i, j); break; }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
                System.out.print(table[i][j]);
            if (i < n -1) System.out.println();
        }
    }

    static void way(int x, int y)
    {
        table[x][y] = '.';

        if (x > 0 && table[x-1][y] == ' ') way(x - 1, y);
        if (y < m && table[x][y+1] == ' ') way(x, y + 1);
        if (x < n && table[x + 1][y] == ' ') way(x + 1, y);
        if (y > 0 && table[x][y-1] == ' ') way(x, y - 1);
    }
}
