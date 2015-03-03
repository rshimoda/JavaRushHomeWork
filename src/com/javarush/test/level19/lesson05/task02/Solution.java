package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new File(scanner.nextLine()));
        scanner.close();

        int count = 0;
        while(fileScanner.hasNext())
        {
            String next = fileScanner.nextLine().replaceAll("[\\p{Punct}]", " ");
            String words[] = next.split(" ");
            for(String x : words)
                if (x.equals("world")) count++;
        }
        fileScanner.close();

        System.out.print(count);
    }
}
