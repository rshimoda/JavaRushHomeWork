package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream stream1 = new FileInputStream(reader.readLine());
        FileInputStream stream2 = new FileInputStream(reader.readLine());
        reader.close();

        if (stream1.available() > 0 && stream2.available() > 0)
        {
            byte buffer1[] = new byte[stream1.available()];
            byte buffer2[] = new byte[stream2.available()];
            int count1 = stream1.read(buffer1);
            int count2 = stream2.read(buffer2);
            byte[] buffer = new byte[count1 + count2];
            for(int i = 0; i < buffer1.length; i++)
                buffer[i] = buffer1[i];
            for(int i = buffer1.length, j = 0; i < buffer.length && j < buffer2.length; i++, j++)
                buffer[i] = buffer2[j];

            fileOutputStream.write(buffer, 0, count1 + count2);
            //fileOutputStream.flush();
        }
    }
}
