package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        FileOutputStream fileOutputStream = new FileOutputStream(scanner.nextLine());
        scanner.close();

        if(fileInputStream.available() > 0)
        {
            byte buffer[] = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            for(int i = 1; i < count; i+=2)
                fileOutputStream.write(buffer[i]);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
