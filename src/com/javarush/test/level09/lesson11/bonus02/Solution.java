package com.javarush.test.level09.lesson11.bonus02;

import java.io.*;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Новая задача: Программа вводит два имени файла. И копирует первый файл на место, заданное вторым именем.
Если файла (который нужно копировать) с указанным именем не существует, то
программа должна вывести надпись «Файл не существует.» и еще раз прочитать имя файла с консоли, а уже потом считывать файл для записи.
*/

public class Solution {
    public static boolean check(String fileName) throws IOException {
        int i = 1;
        try {
            FileInputStream fileInputStreamTest = new FileInputStream(fileName);
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не существует.");
            i = 0;
        }
        if (i == 1) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFileName = reader.readLine();

        if (!check(sourceFileName)) {
            for (; ; ) {
                sourceFileName = reader.readLine();
                if (check(sourceFileName)) break;
            }
            String destinationFileName = reader.readLine();

            FileInputStream fileInputStream = new FileInputStream(sourceFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();

        } else {
            String destinationFileName = reader.readLine();

            FileInputStream fileInputStream = new FileInputStream(sourceFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
