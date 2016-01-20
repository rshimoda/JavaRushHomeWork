package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        new Human("A", "B", 20, true);
        new Human("dev", "architeckt");
        new Human(new ArrayList<String>().add("Cat"), new ArrayList<String>().add("Marselio"));
        new Human(new ArrayList<String>().add("swimming"), "expert");
        new Human("Rolling", 1);
        new Human("Apple", 2);
        new Human("Samsung", "Android", 4.2);
        new Human("Java", 5);
        new Human("Marie", new ArrayList<String>().add("Marshal"));
        new Human(new ArrayList<String>().add("Eng"));

    }

    public static class Human {
        //напишите тут ваши переменные и конструкторы
        String name;
        String surname;
        int age;
        String sex;

        String job;
        String post;

        boolean pet;
        boolean petName;

        boolean hobby;
        String hobbyExp;

        String sport;
        int rank;

        String pcBrand;
        String pcOs;
        int old;

        String mobileBrand;
        String mobileOs;
        float apiLvl;

        String progLang;
        short exp;

        String wife;
        boolean kids;

        boolean langs;

        public Human(String name, String surname, int age, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            if (sex = true)
                this.sex = "мужчина";
            else this.sex = "женщина";
        }

        public Human(String job, String post) {
            this.job = job;
            this.post = post;
        }

        public Human(boolean pet, boolean petName) {
            this.pet = pet;
            this.petName = petName;
        }

        public Human(boolean hobby, String hobbyExp) {
            this.hobby = hobby;
            this.hobbyExp = hobbyExp;
        }

        public Human(String sport, int rank) {
            this.sport = sport;
            this.rank = rank;
        }

        public Human(String pcBrand, String pcOs, int old) {
            this.pcBrand = pcBrand;
            this.pcOs = pcOs;
            this.old = old;
        }

        public Human(String mobileBrand, String mobileOs, double apiLvl) {
            this.mobileBrand = mobileBrand;
            this.mobileOs = mobileOs;
            this.apiLvl = (float) apiLvl;
        }

        public Human(String progLang, short exp) {
            this.progLang = progLang;
            this.exp = exp;
        }

        public Human(String wife, boolean kids) {
            this.wife = wife;
            this.kids = kids;
        }

        public Human(boolean langs) {
            this.langs = langs;
        }
    }
}
