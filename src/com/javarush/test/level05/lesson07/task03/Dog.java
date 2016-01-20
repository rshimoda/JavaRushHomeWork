package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog {
    //Напишите тут ваш код
    private String name = null;
    private int height = Integer.parseInt(null);
    private String color = null;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int height) {
        this.name = name;
        if (height != Integer.parseInt(null)) this.height = height;
        else this.height = 5;
    }

    public void initialize(String name, int height, String color) {
        this.name = name;
        if (height != Integer.parseInt(null)) this.height = height;
        else this.height = 5;
        this.color = color;
    }
}
