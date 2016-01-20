package com.javarush.test.level05.lesson12.home03;


public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        //Напишите тут ваш код
        Cat tomcat = new Cat("Tom", 4, "blue");
        Dog ralfdog = new Dog("Ralf", "buldog", "angry");
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name) {
            this.name = name;
        }

        public Mouse(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //Напишите тут ваши классы
    public static class Cat {
        private String name;
        private int age;
        private String color;

        public Cat(String name) {
            this.name = name;
        }

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Cat(String name, int age, String color) {
            this.name = name;
            this.color = color;
            this.age = age;
        }
    }

    public static class Dog {
        private String name;
        private String tipe;
        private String charecter;

        public Dog(String name) {
            this.name = name;
        }

        public Dog(String name, String tipe) {
            this.name = name;
            this.tipe = tipe;
        }

        public Dog(String name, String tipe, String charecrer) {
            this.name = name;
            this.tipe = tipe;
            this.charecter = charecrer;
        }
    }
}
