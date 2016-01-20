package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("(<" + args[0] + ".*>.*</" + args[0] + ">)"); //(<tag.*>.*</tag>)

        Scanner consoleScanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(new File(consoleScanner.nextLine()));
        consoleScanner.close();

        while (fileScanner.hasNext()) {
            String tmp = fileScanner.nextLine();
            stringBuilder.append(tmp);

            if (tmp.matches("<" + args[0] + ".*>.*</" + args[0] + ">")) { //^[^>|<]*<span.*
                stringBuilder.append("\n");
            }
        }
        fileScanner.close();

        Matcher matcher = pattern.matcher(stringBuilder.toString());

        String result = "";

        while (matcher.find()) {
            result += matcher.group();
        }

        result = result.replaceAll("</" + args[0] + "><" + args[0], "</" + args[0] + ">∆<" + args[0]);
        for (String x : result.split("∆")) {
            System.out.println(x);
        }
    }
}
