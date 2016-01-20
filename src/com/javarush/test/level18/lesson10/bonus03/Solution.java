package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        File file = new File(scanner.nextLine());
        scanner.close();

        if ("-u".equals(args[0])) {
            StringBuilder productName = new StringBuilder();
            for (int i = 2; i < args.length - 2; i++)
                productName.append(args[i]).append(" ");
            productName.deleteCharAt(productName.length() - 1);

            update(file, args[1], productName.toString(), args[args.length - 2], args[args.length - 1]);
        } else if ("-d".equals(args[0])) delete(file, args[1]);
    }

    private static void update(File file, String updateIndex, String productName, String price, String quantity) throws IOException {
        ArrayList<String> fileInput = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (bufferedReader.ready()) {
            String input = bufferedReader.readLine(), index = input.substring(0, 8).replaceAll(" ", "");

            if (index.equals(updateIndex)) {
                fileInput.add(String.format("%-8.8s%-30.30s%-8s%-4s", index, productName, price, quantity));
            } else {
                fileInput.add(input);
            }
        }
        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (String x : fileInput) {
            bufferedWriter.write(x);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static void delete(File file, String deleteIndex) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<String> fileInput = new ArrayList<>();

        while (bufferedReader.ready()) {
            String input = bufferedReader.readLine();
            String index = input.substring(0, 8).replaceAll(" ", "");
            if (index.equals(deleteIndex))
                continue;

            fileInput.add(input);
        }
        bufferedReader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (String x : fileInput) {
            bufferedWriter.write(x);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
