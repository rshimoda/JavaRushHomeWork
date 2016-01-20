package com.javarush.test.level03.lesson06.task01;

/* Мама мыла раму
Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
Подсказка: их 6 штук. Каждую комбинацию вывести с новой строки. Слова не разделять. Пример:
МылаРамуМама
РамуМамаМыла
...
*/

public class Solution {
    public static void main(String[] args) {
        //Напишите тут ваш код
        String ma[] = {"Мама", "Мыла", "Раму"};

        for (int a = 0; a <= 2; a++) {
            //System.out.print("Running for: a is "+a+" | ");
            for (int b = 0; b <= 2; b++) {
                //System.out.print(" b is "+b+" | ");
                for (int c = 0; c <= 2; c++) {
                    //System.out.println(" c is "+c+" || ");
                    if (a != b) {
                        //System.out.print("Running if: bool(a!=b) "+(a!=b)+" | ");
                        if (b != c) {
                            //System.out.print("bool(b!=c) "+(b!=c)+" | ");
                            if (a != c) {
                                //System.out.println("bool(a!=c) "+(a!=c)+" || ");
                                // System.out.println("OK");
                                System.out.println(ma[a] + ma[b] + ma[c]);
                            }
                        }
                    } else {
                        //System.out.println("a:"+a+"; b:"+b+"; c:"+c+"--> Break used");
                        break;
                    }

                }
            }
        }
    }
}