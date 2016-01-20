package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Character> list = new ArrayList<Character>();
        InputStream stream = new FileInputStream(reader.readLine());
        while (stream.available() > 0)
            list.add((char) stream.read());

        stream.close();

        for (char x : list) System.out.print(x);

    }
}
