package com.javarush.test.level04.lesson13.task02;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код
        for (int i = 1; i <= 10; i++) {
            for (int a = 1; a <= 10; ++a) {
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
