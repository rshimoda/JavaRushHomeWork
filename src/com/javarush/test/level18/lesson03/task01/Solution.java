package com.javarush.test.level18.lesson03.task01;

import java.io.FileInputStream;
import java.util.Scanner;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner  = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        scanner.close();

        int max = 0;
        while(inputStream.available() > 0)
        {
            int val = inputStream.read();
            if(max < val) max = val;
        }
        inputStream.close();
        System.out.println(max);
    }
}
