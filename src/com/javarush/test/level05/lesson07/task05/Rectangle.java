package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle {
    //Напишите тут ваш код

    private int top;
    private String left;
    private int width;
    private int height;

    private String Rectangle = "Rectangle";

    public void initialize(int top, String left, int width, int height) {
        this.Rectangle = top + left + width + height;
    }

    public void initialize(int top, String left) {
        this.width = 0;
        this.height = 0;
        this.top = top;
        this.left = left;
    }

    public void initialize(int top, String left, int width) {
        this.width = this.height;
        this.top = top;
        this.left = left;
    }

    public void initialize(String Rectangle) {
        this.Rectangle = Rectangle;

    }
}
