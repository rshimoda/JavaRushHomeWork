package com.javarush.test.level18.lesson03.task03;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.util.Arrays.sort;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        scanner.close();
        //Thread loader = new Loader();
        //loader.start();
        int array[] = new int[inputStream.available()];
        while (inputStream.available() > 0)
        {
            array[array.length - inputStream.available()] = inputStream.read();
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count[] = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            if (map.containsValue(array[i])) continue;
            int counter = 0;
            for (int j = i; j < array.length; j++)
            {
                if (array[i] == array[j]) counter++;
            }
            map.put(counter, array[i]);
            count[i] = counter;
        }
        inputStream.close();

        sort(count);
        //loader.interrupt();
        //System.out.println("\nОбработка завершена:");
            for (int i = count.length - 1; i >= 0; i--)
            {
                if (map.get(count[i]) != null)
                {
                    if (map.get(count[i]) == map.get(count[i - 1]) && i != 0) continue;
                    System.out.print(map.get(count[i]) + " ");
                }

            }
    }
}