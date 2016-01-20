package com.javarush.test.level06.lesson05.task03;

/* 10 000 объектов Cat и Dog
Создать в цикле 10 000 объектов Cat и Dog. (Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).
*/

public class Solution {
    public static void main(String[] args) {
        //Напишите тут ваш код
        int count;
        Cat ob = new Cat(0);
        Dog od = new Dog(0);
        for (count = 1; count <= 100000; count++) {
            ob.generator(count);
            od.generator(count);
        }

    }
}

class Cat {
    int x;

    Cat(int i) {
        x = i;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat destroyed");
    }

    void generator(int i) {
        Cat o = new Cat(i);
    }
}

class Dog {
    int x;

    Dog(int i) {
        x = i;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog destroyed");
    }

    void generator(int i) {
        Dog o = new Dog(i);
    }
}