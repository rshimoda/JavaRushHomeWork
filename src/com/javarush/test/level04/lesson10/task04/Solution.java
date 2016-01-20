package com.javarush.test.level04.lesson10.task04;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while. Буквы в одной строке не разделять.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //Напишите тут ваш код
        int i = 100;

        while (i > 0) {
            System.out.print("S");
            i--;
            if (i == 100) continue;
            if (i % 10 == 0) System.out.println();
        }
    }
}
