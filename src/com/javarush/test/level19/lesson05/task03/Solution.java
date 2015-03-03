package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new File(scanner.nextLine()));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(scanner.nextLine()));
        scanner.close();

        ArrayList<Integer> list = new ArrayList<Integer>();
        while(fileScanner.hasNext())
            if(fileScanner.hasNextInt())
                list.add(fileScanner.nextInt());
            else fileScanner.next();
        fileScanner.close();

        for(int x : list)
            outputStreamWriter.write(String.format("%d ", x));
        outputStreamWriter.close();
    }
}
