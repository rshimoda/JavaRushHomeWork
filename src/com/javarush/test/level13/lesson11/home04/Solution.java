package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream OutStream = new FileOutputStream(reader.readLine());

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String inPut = reader.readLine();
            list.add(inPut);
            if (inPut.equals("exit")) break;
            list.add("\n");
        }

        for (String x : list) {

            char[] z = x.toCharArray();
            for (int i = 0; i < z.length; i++) {
                OutStream.write((char) z[i]);
            }
        }
        OutStream.close();
    }
}
