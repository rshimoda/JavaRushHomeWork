package com.javarush.test.level05.lesson07.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя инициализаторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle {
    // - centerX, centerY, radius
    private String c1 = "circle";

    public void initialize(int centerX, String centerY, int radius) {
        this.c1 = centerX + centerY + radius;
    }


    //- centerX, centerY, radius, width
    private String c2 = "circle";

    public void initialize(int centerX, String centerY, int radius, int width) {
        this.c2 = centerX + centerY + radius + width;
    }

    // - centerX, centerY, radius, width, color
    private String c3 = "c3";

    public void initialize(int centerX, int centerY, int radius, int width, String color) {
        this.c3 = centerX + centerY + radius + width + color;
    }
}
