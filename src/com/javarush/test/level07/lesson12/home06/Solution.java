package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //Написать тут ваш код
        ArrayList<Human> humanArray = new ArrayList<Human>();
        Human buf = new Human("Саша", true, 76, null, null);
        humanArray.add(buf);
        System.out.println(humanArray.get(0));
        buf = new Human("Даня", true, 77, null, null);
        humanArray.add(buf);
        System.out.println(humanArray.get(1));
        buf = new Human("Ланя", false, 71, null, null);
        humanArray.add(buf);
        System.out.println(humanArray.get(2));
        buf = new Human("Маня", false, 76, null, null);
        humanArray.add(buf);
        System.out.println(humanArray.get(3));
        buf = new Human("Коля", true, 51, humanArray.get(2), humanArray.get(0));
        humanArray.add(buf);
        System.out.println(humanArray.get(4));
        buf = new Human("Оля", false, 91, humanArray.get(3), humanArray.get(1));
        humanArray.add(buf);
        System.out.println(humanArray.get(5));

        buf = new Human("Аня", false, 21, humanArray.get(5), humanArray.get(4));
        humanArray.add(buf);
        System.out.println(humanArray.get(6));
        buf = new Human("Воля", true, 21, humanArray.get(5), humanArray.get(4));
        humanArray.add(buf);
        System.out.println(humanArray.get(7));
        buf = new Human("Соля", true, 21, humanArray.get(5), humanArray.get(4));
        humanArray.add(buf);
        System.out.println(humanArray.get(8));


    }

    public static class Human {
        private String name;
        Boolean sex;
        int age;
        Human mother;
        Human father;
        //Написать тут ваш код

        Human(String name, Boolean sex, int age, Human mother, Human father) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (mother != null) this.mother = mother;
            if (father != null) this.father = father;

        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
