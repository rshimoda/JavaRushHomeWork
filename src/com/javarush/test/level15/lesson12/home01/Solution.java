package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String value;
        while (true) {
            value = reader.readLine();
            if (value.equals("exit")) break;
            boolean isDouble = false;
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == '.') {
                    print(Double.parseDouble(value));
                    isDouble = true;
                }
            }

            if (isDouble) continue;
            try {
                if (Integer.parseInt(value) > 0 && Integer.parseInt(value) < 128) print(Short.parseShort(value));
                else if (Integer.parseInt(value) >= 128) print(Integer.parseInt(value));
                else print(value);
            }
            catch (Exception e) {
                print(value);
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
