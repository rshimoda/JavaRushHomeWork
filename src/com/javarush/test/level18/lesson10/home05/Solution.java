package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать во второй файл
Закрыть потоки
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        StringBuilder stringBuilder = new StringBuilder();
        while(fileReader.ready())
            stringBuilder.append(fileReader.readLine());

        String result = stringBuilder.toString();
        StringBuilder num = new StringBuilder();
        for(int i = 0; i < result.length(); i++)
        {
            if (result.charAt(i) != ' ') num.append(result.charAt(i));
            else
            {
                double val = Double.parseDouble(num.toString());
                num.delete(0, num.length() - 1);
                fileWriter.write(String.valueOf(Math.round(val)));
            }
        }

    }
}
