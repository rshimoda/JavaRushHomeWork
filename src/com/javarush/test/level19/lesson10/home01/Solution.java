package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner fileScanner = new Scanner(new File(args[0]));

        TreeMap<String, Double> map = new TreeMap<String, Double>();

        while(fileScanner.hasNext())
        {
            String name = fileScanner.next();
            double value = Double.parseDouble(fileScanner.next());

            if(map.containsKey(name)) {
                double newValue = map.get(name) + value;
                map.put(name, newValue);
            } else {
                map.put(name, value);
            }
        }
        fileScanner.close();

        for(Map.Entry<String, Double> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
