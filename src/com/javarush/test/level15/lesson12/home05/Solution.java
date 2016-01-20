package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public static void main(String[] args) {

        try {
            System.err.print("0 ");

        }
        catch (Error e) {
            System.err.print("1 ");
        }
        System.err.print("2 ");

    }

    public static long pow(long a, long b) {

        long result = 1;
        while (b > 0) {
            result *= a;
            b--;
        }
        return result;

    }
}

