package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog {
    //Напишите тут ваш код
    private String name = null;
    private int height = Integer.parseInt(null);
    private String color = null;

    public Dog(String name) {
        this.name = name;
    }

    public Dog(String name, int height) {
        this.name = name;
        if (height != Integer.parseInt(null)) this.height = height;
        else this.height = 5;
    }

    public Dog(String name, int height, String color) {
        this.name = name;
        if (height != Integer.parseInt(null)) this.height = height;
        else this.height = 5;
        this.color = color;
    }
}
