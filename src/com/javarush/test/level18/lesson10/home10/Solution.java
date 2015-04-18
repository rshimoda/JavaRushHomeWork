package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> files = new TreeSet<>();
        LinkedList<String> lines = new LinkedList<>();

        String input = scanner.nextLine();
        while (!input.equals("end"))
        {
            files.add(input);
            input = scanner.next();
        }
        scanner.close();

        File file = new File(files.first().substring(0, files.first().lastIndexOf(".")));

        BufferedReader fileScanner;
        for (String x : files) {
            fileScanner = new BufferedReader(new FileReader(x));
            while (fileScanner.ready())
                lines.add(fileScanner.readLine());
            fileScanner.close();
        }

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
