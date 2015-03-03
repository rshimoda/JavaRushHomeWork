package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки ввода-вывода.
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов.
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new File(scanner.nextLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanner.nextLine()));
        scanner.close();

        while (fileScanner.hasNext())
        {
            String line = fileScanner.nextLine().replaceAll("[\\p{Punct}]", "");
            bufferedWriter.write(String.format("%s%n", line));
        }
        fileScanner.close();
        bufferedWriter.close();
    }
}
