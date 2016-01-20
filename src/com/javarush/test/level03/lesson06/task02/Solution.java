package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран надпись: таблицу умножения 10 на 10:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution {
    public static void main(String[] args) {
        //Напишите тут ваш код
        int a = 1;
        for (int i = 1; i <= 10; ++i) {
            //for(int b=0;b<=10;++b){
            int m = a * i;
            System.out.print(m + " ");
            m += i;
            System.out.print(m + " ");
            m = m + i;
            System.out.print(m + " ");
            m = m + i;
            System.out.print(m + " ");
            m = m + i;
            System.out.print(m + " ");
            m = m + i;
            System.out.print(m + " ");
            m = m + i;
            System.out.print(m + " ");
            m = m + i;
            System.out.print(m + " ");
            m = m + i;
            System.out.print(m + " ");
            m = m + i;
            System.out.println(m + " ");

            //System.out.print(m+" ");
            //if(m%10==0) System.out.println();
            //}
        }
    }
}