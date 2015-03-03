package com.javarush.test.level18.lesson10.bonus01;
 
/* Шифровка
Придумать механизм шифровки/дешифровки
 
Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        if(args[0].equals("-e")) encrypt(args[1], args[2]);
        else if(args[0].equals("-d")) decrypt(args[1], args[2]);
    }

    private static void encrypt(String fileName, String fileOutputName) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        if (fileInputStream.available() > 0)
        {
            byte buffer[] = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            for(int i = 0; i < buffer.length; i++)
                buffer[i]*=(buffer[i]%2 == 0 ? 2 : 3);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
            fileOutputStream.write(buffer, 0, count);
            fileOutputStream.close();
        }
        fileInputStream.close();
    }

    private static void decrypt(String fileName, String fileOutputName) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        if (fileInputStream.available() > 0)
        {
            byte buffer[] = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            for(int i = 0; i < buffer.length; i++)
                buffer[i]/=(buffer[i]%2 == 0 ? 2 : 3);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
            fileOutputStream.write(buffer, 0, count);
            fileOutputStream.close();
        }
        fileInputStream.close();
    }
}