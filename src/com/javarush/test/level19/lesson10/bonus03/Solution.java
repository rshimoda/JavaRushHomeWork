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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();
        scanner.close();

        Scanner fileScanner = new Scanner(new File(fileName));

        String tagName = args[0];
        StringBuilder buffer = new StringBuilder();

        while (fileScanner.hasNext()) {
            buffer.append(fileScanner.nextLine());
        }
        buffer.append(" ");
        fileScanner.close();

        ArrayList<String> result = new ArrayList<>();
        Stack<Integer> tagIndexes = new Stack<>();

        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == '<') {

                if (!tagIndexes.isEmpty() && i + tagName.length() + 3 < buffer.length() && buffer.substring(i, i + tagName.length() + 3).equals("</" + tagName + ">")) {
                    result.add(buffer.substring(tagIndexes.pop(), i + tagName.length() + 3));
                    i += tagName.length() + 2;
                } else {
                    String possibleTagName = "";
                    for (int j = i + 1; j < buffer.length(); j++) {
                        char currentCharacter = buffer.charAt(j);

                        if (currentCharacter == ' ' && possibleTagName.isEmpty()) {
                            possibleTagName = buffer.substring(i + 1, j);
                        }
                        if (currentCharacter == '<') {
                            possibleTagName = "";
                        }
                        if (currentCharacter == '>' && (buffer.substring(i + 1, j).equals(tagName) || possibleTagName.equals(tagName))) {
                            tagIndexes.push(i);
                            i = j;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = result.size() - 1; i > 0 ; i--) {
            if (result.get(i).contains(result.get(i - 1))) {
                result.add(i - 1, result.remove(i));
            }
        }

        for (String x :
                result) {
            System.out.println(x);
        }
    }
}
