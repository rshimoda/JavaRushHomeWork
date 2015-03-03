package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner streamReader = new Scanner(new File(scanner.nextLine()));
        BufferedWriter streamWriter = new BufferedWriter(new FileWriter(scanner.nextLine()));
        scanner.close();

        while (streamReader.hasNext())
        {
            String text = streamReader.nextLine();
            text = text.replaceAll("\\.", "!");
            streamWriter.write(String.format("%s%n", text));
        }
        streamReader.close();
        streamWriter.close();
    }
}
