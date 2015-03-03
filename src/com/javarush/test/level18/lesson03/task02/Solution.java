package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        scanner.close();

        int min = inputStream.read();
        while (inputStream.available() > 0)
        {
            int b = inputStream.read();
            if (b < min)
            {
                min = b;
            }
        }
        inputStream.close();

        System.out.println(min);
    }
}
