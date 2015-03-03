package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File(args[0]));

        Map<String, Double> map = new TreeMap<String, Double>();
        double maxValue = 0;
        while (scanner.hasNext())
        {
            String name = scanner.next();
            double value = Double.parseDouble(scanner.next());
            if(map.containsKey(name))
            {
                double newValue = map.get(name) + value;
                if(newValue > maxValue) maxValue = newValue;
                map.put(name, newValue);
            }
            else
            {
                if(value > maxValue)
                    maxValue = value;
                map.put(name, value);
            }
        }
        scanner.close();

        Set<String> name = new TreeSet<String>();
        for(Map.Entry<String, Double> entry : map.entrySet())
            if(entry.getValue() >= maxValue) name.add(entry.getKey());

        for(String x : name)
            System.out.println(x);
    }
}
