package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat {
    private String name = null;
    private int weight = Integer.parseInt(null);
    private int age = Integer.parseInt(null);
    private String color = null;
    private String adress = null;
    //Напишите тут ваш код

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        if (age != Integer.parseInt(null)) this.age = age;
        else this.age = 5;
    }

    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Cat(int weight, String color) {
        if (weight != Integer.parseInt(null)) this.weight = weight;
        else this.weight = 5;
        this.color = color;
    }

    public Cat(int weight, String color, String adress) {
        if (weight != Integer.parseInt(null)) this.weight = weight;
        else this.weight = 5;
        this.color = color;
        this.adress = adress;
    }
}
