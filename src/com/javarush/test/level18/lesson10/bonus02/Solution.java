package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        scanner.close();

        ArrayList<String> lines = new ArrayList<String>();
        while (fileReader.ready())
        {
            lines.add(fileReader.readLine());
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        int maxId = Integer.MIN_VALUE;
        for (String x : lines)
        {
            if (x.equals("")) continue;
            fileWriter.write(String.format("%s%n", x));
            int id = Integer.parseInt(x.substring(0, 8).replaceAll("[\\p{Space}|\\p{Punct}|\\p{L}]", ""));
            if (id > maxId) maxId = id;
        }

        {
            String name = args[1];
            for (int i = 2; i < args.length - 2; i++)
                name += " " + args[i];

            if(args[0].equals("-c"))
                fileWriter.write(String.format("%-8.8s%-30.30s%8.8s%4.4s%n", maxId == Integer.MIN_VALUE ? "0" : String.valueOf(++maxId), name, args[args.length - 2], args[args.length - 1]));
        }

        fileReader.close();
        fileWriter.close();
    }
}