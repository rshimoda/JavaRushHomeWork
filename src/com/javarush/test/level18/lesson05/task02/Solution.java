package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream stream = new BufferedInputStream(new FileInputStream(reader.readLine()));
        reader.close();

        int count = 0;
        while(stream.available() > 0)
        {
            if(((char) stream.read() == ',')) count++;
        }
        stream.close();

        System.out.print(count);
    }
}
