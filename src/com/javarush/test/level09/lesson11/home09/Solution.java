package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //Напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Vasia", new Cat("Vasia"));
        map.put("Kotofei", new Cat("Kotofei"));
        map.put("Leonidas", new Cat("Leonidas"));
        map.put("Igvar", new Cat("Igvar"));
        map.put("Marselio", new Cat("Marselio"));
        map.put("Rijeiro", new Cat("Rijeiro"));
        map.put("Masha", new Cat("Masha"));
        map.put("Aristarh", new Cat("Aristarh"));
        map.put("Tsar", new Cat("Tsar"));
        map.put("Graf", new Cat("Graf"));

        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //Напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        for (Cat cat : map.values()) {
            set.add(cat);
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
