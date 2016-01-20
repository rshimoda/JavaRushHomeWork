package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine() + "&"; // Добавляем "&" для исправной работы цикла
        String result = "";
//----------------------------------------------------------------------------------------------------------------------
        int startIndex = 0;
        for (int i = 0; i < url.length(); i++) //Поиск начала параметров
            if (url.charAt(i) == '?') {
                if (url.charAt(i + 1) == '?') continue;
                startIndex = i;
                break;
            }
//----------------------------------------------------------------------------------------------------------------------
        int i = startIndex + 1;
        for (; i < url.length(); i++) {
            if (url.charAt(i) == '=') // Если у параметра есть значение, пролистать индекс до следующего параметра
            {
                int x = i;
                while (x < url.length() - 1 && url.charAt(x) != '&') x++;
                if (url.charAt(x) == '&') {
                    i = x;
                }
            }
            if (url.charAt(i) == '?' || url.charAt(i) == '.' || url.charAt(i) == ',') continue;
            if (result.length() > 1) if (result.charAt(result.length() - 1) == ' ' && url.charAt(i) == '&') continue;
            if (url.charAt(i) == '&' && url.charAt(i - 1) != '&' && i != url.length() - 1) // Вместо "&" печатать пробел
            {
                result += " ";
                continue;
            }
            if (i != url.length() - 1) //Не печатать последний символ "&"
                result += url.charAt(i);
        }
        System.out.println(result);
//----------------------------------------------------------------------------------------------------------------------
        String value = "";
        i = startIndex + 1;
        for (; i < url.length(); i++) //Проверка наличия параметра "obj"
        {
            if (url.charAt(i - 1) != 'o'
                    && url.charAt(i) == 'o'
                    && url.charAt(i + 1) == 'b'
                    && url.charAt(i + 2) == 'j'
                    && url.charAt(i + 3) == '=') {
                i += 4;
                while (url.charAt(i) == '=') i++;
                while (url.charAt(i) != '&' && i < url.length() - 1) {
                    value += url.charAt(i);
                    i++;
                }
                try {
                    alert(Double.parseDouble(value));
                }
                catch (Exception e) {
                    alert(value);
                }
                value = "";
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------------------------------
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
