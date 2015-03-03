package com.javarush.test.level18.lesson03.task05;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        scanner.close();

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        while(fileInputStream.available() > 0)
        {
            int b = fileInputStream.read();
            if(map.containsKey(b))
            {
                int count = map.get(b) + 1;
                map.put(b, count);
            }
            else map.put(b, 1);
        }
        fileInputStream.close();

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            System.out.print(entry.getKey() + " ");
        }
    }
}
