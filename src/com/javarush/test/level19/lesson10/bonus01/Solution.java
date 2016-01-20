package com.javarush.test.level19.lesson10.bonus01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> file1 = new ArrayList<>(), file2 = new ArrayList<>();

        Scanner fileScanner1 = new Scanner(new File(scanner.nextLine())), fileScanner2 = new Scanner(new File(scanner.nextLine()));
        while (fileScanner1.hasNext() || fileScanner2.hasNext()) {
            if (fileScanner1.hasNext()) file1.add(fileScanner1.nextLine());
            if (fileScanner2.hasNext()) file2.add(fileScanner2.nextLine());
        }
        fileScanner1.close();
        fileScanner2.close();

        while (file1.size() > 0) {
            if (file1.get(0).equals(file2.get(0))) {
                lines.add(new LineItem(Type.SAME, file1.get(0)));
                file1.remove(0);
                file2.remove(0);
            } else if (file1.get(0).equals(file2.get(1))) {
                lines.add(new LineItem(Type.ADDED, file2.get(0)));
                file2.remove(0);
            } else {
                lines.add(new LineItem(Type.REMOVED, file1.get(0)));
                file1.remove(0);
            }
        }
        if (file2.size() > 0) {
            lines.add(new LineItem(Type.ADDED, file2.get(0)));
        }

        for (LineItem x : lines) {
            System.out.println(x.type.toString() + " " + x.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
