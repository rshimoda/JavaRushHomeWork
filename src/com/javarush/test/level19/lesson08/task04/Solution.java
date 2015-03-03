package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream moddedStream = new PrintStream(byteArrayOutputStream);
        System.setOut(moddedStream);

        testString.printSomething();

        String line = byteArrayOutputStream.toString();

        System.setOut(defaultStream);

        String[] components = line.split(" ");
        int result = 0;
        switch (components[1].charAt(0))

        {
            case'+':
                result = Integer.parseInt(components[0]) + Integer.parseInt(components[2]);
                break;
            case'-':
                result = Integer.parseInt(components[0]) - Integer.parseInt(components[2]);
                break;
            case'*':
                result = Integer.parseInt(components[0]) * Integer.parseInt(components[2]);
                break;
        }
        line = line.replace("\n", "") + String.valueOf(result);
        System.out.print(line);
        //System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

