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
import java.util.Scanner;

import static java.util.Collections.sort;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> list = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            String read = scanner.nextLine();
            if(read.equals("end"))  break;
            else list.add(read);
        }
        scanner.close();

        int p = list.get(0).length(), k = 0;


        String parts[] = list.get(0).split("\\.");
        String file = "";
        for(int i = 0; i < parts.length; i++)
            if(!parts[i].startsWith("part"))
                if(i == parts.length - 2) file+=parts[i];
                else file+="."+parts[i];

        if(file.startsWith(".")) file = file.substring(1, file.length());
        sort(list);

        FileOutputStream writer = new FileOutputStream(file);
        ArrayList<byte[]> buffers = new ArrayList<byte[]>();
        for(String x : list)
        {
            FileInputStream stream = new FileInputStream(x);
            if(stream.available()>0)
            {
                byte buffer[] = new byte[stream.available()];
                int count = stream.read(buffer);
                buffers.add(buffer);
            }
            stream.close();
        }
        int size = 0;
        for(byte[] x : buffers)
            size+=x.length;
        byte[] result = new byte[size];
        int count = 0;
        for(byte[] x: buffers)
        {
            for(int i = 0; i < x.length; i++){
                result[count] = x[i];
                count++;
            }
        }
        writer.write(result);
        writer.close();
    }
}
