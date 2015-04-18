package com.javarush.test.level18.lesson10.home08;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(! input.equals("exit"))
        {
            new ReadThread(input);
            input = scanner.nextLine();
        }
        scanner.close();
    }

    public static class ReadThread extends Thread {
        String file;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxCount = 1, maxByte = 0;

        public ReadThread(String fileName)
        {
            //implement constructor body
            this.file = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            try
            {
                FileReader fileReader = new FileReader(file);
                while (fileReader.ready())
                {
                    int x = fileReader.read();
                    if (map.containsKey(x))
                    {
                        map.replace(x, map.get(x) + 1);
                        if (map.get(x) > maxCount)
                        {
                            maxCount = map.get(x);
                            maxByte = x;
                        }
                    } else map.put(x, 1);
                }
                fileReader.close();
            } catch (Exception e) {
                //NOP
            }

                resultMap.put(file, maxByte);
        }
    }
}
