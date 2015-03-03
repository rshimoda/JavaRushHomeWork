package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки ввода-вывода
*/

import java.io.*;
//import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        String destFileName1 = reader.readLine();
        String destFileName2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);
        FileOutputStream outputStream1 = new FileOutputStream(destFileName1);
        FileOutputStream outputStream2 = new FileOutputStream(destFileName2);
        reader.close();

        byte[] buffer2 = new byte[fileInputStream.available()/2];
        byte[] buffer1 = new byte[fileInputStream.available()/2 + fileInputStream.available()%2];

        outputStream1.write(buffer1, 0, fileInputStream.read(buffer1));
        outputStream2.write(buffer2, 0, fileInputStream.read(buffer2));

        fileInputStream.close();
        outputStream1.close();
        outputStream2.close();
        /*Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(scanner.nextLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(scanner.nextLine());
        scanner.close();

        if(fileInputStream.available() > 0)
        {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            int middle;
            if(count/2 + count%2 == count/2) middle = count/2 - 1;
            else middle = count/2;

            for (int i = 0; i < middle; i++)
                fileOutputStream1.write(buffer[i]);
            for(int i = middle; i < buffer.length; i++)
                fileOutputStream2.write(buffer[i]);
        }
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();*/
    }
}
