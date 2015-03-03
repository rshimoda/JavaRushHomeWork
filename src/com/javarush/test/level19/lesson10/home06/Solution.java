package com.javarush.test.level19.lesson10.home06;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException
    {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        print();

        String result = byteArrayOutputStream.toString();

        System.setOut(consoleStream);

        String[] strings = result.split(" ");
        for (int i = 0; i < strings.length; i++)
            try { if (map.containsKey(Integer.parseInt(strings[i]))) strings[i] = map.get(Integer.parseInt(strings[i])); }
            catch (Exception e) { /*NOP*/ }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length - 1; i++)
            stringBuilder.append(strings[i]).append(" ");
        stringBuilder.append(strings[strings.length - 1]);

        System.out.print(stringBuilder.toString());
    }

    static void print() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true)
        {
            String line = bufferedReader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();

        scanner.close();
    }
}
