package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //Написать тут ваш код

        Human CH1 = new Human("CH1", true, 20, null);
        Human CH2 = new Human("CH2", false, 17, null);
        Human CH3 = new Human("CH3", true, 15, null);

        ArrayList<Human> PCH = new ArrayList<Human>();
        PCH.add(CH1);
        PCH.add(CH2);
        PCH.add(CH3);

        Human F = new Human("F", true, 46, PCH);
        Human M = new Human("M", false, 45, PCH);

        ArrayList<Human> GP1CH = new ArrayList<Human>();
        GP1CH.add(F);

        ArrayList<Human> GP2CH = new ArrayList<Human>();
        GP2CH.add(M);

        Human GF1 = new Human("GF1", true, 86, GP1CH);
        Human GF2 = new Human("GF2", true, 84, GP2CH);
        Human GM1 = new Human("GM1", false, 80, GP1CH);
        Human GM2 = new Human("GM2", false, 81, GP2CH);

        System.out.println(GF1);
        System.out.println(GF2);
        System.out.println(GM1);
        System.out.println(GM2);
        System.out.println(F);
        System.out.println(M);
        System.out.println(CH1);
        System.out.println(CH2);
        System.out.println(CH3);

    }


    public static class Human {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;
            if (this.children == null) {
                return text;
            }
            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
