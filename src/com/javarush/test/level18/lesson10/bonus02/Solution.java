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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static ArrayList<String> lines = new ArrayList<>();
    public static int maxId = 0;

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.next());
        scanner.close();

        restoreInfo(file);

        StringBuilder name = new StringBuilder();
        for (int i = 1; i < args.length-2; i++)
            name.append(args[i]).append(" ");
        name.deleteCharAt(name.length() - 1);

        if (args[0].equals("-c"))
            lines.add(String.format("%-8d%-30s%-8s%-4d", ++maxId, name.toString(), args[args.length-2], Integer.parseInt(args[args.length-1])));
        else lines.add(String.format("%-8d%-30s%-8s%-4d", Integer.parseInt(args[0]), name.toString(), args[args.length-2], Integer.parseInt(args[args.length-1])));

        write(file);
    }

    public static void restoreInfo(File file) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ArrayList<Integer> ids = new ArrayList<>();
        while (reader.ready())
        {
            String line = reader.readLine();
            lines.add(line);
            String sId = line.substring(0, 8).replaceAll(" ", "");

            try
            {
                int id = Integer.valueOf(sId);
                if (id > maxId)
                    maxId = id;
            }
            catch (Exception e)
            {
                //NOP
            }
        }
        reader.close();
    }

    public static void write(File file) throws IOException
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        int count = 0;
        for (String x : lines) {
            writer.write(x);
            if (count < lines.size() - 1) writer.newLine();
            count++;
        }
        writer.close();
    }
}
