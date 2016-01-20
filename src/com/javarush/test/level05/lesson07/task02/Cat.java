package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat {
    //Напишите тут ваш код
    private String name = null;
    private int weight = Integer.parseInt(null);
    private int age = Integer.parseInt(null);
    private String color = null;
    private String adress = null;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int age) {
        this.name = name;
        if (age != Integer.parseInt(null)) this.age = age;
        else this.age = 5;
    }

    public void initialize(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void initialize(int weight, String color) {
        if (weight != Integer.parseInt(null)) this.weight = weight;
        else this.weight = 5;
        this.color = color;
    }

    public void initialize(int weight, String color, String adress) {
        if (weight != Integer.parseInt(null)) this.weight = weight;
        else this.weight = 5;
        this.color = color;
        this.adress = adress;
    }

}
