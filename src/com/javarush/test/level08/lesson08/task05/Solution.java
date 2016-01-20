package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>(createMap());
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair : map.entrySet()) System.out.println(pair.getKey() + " " + pair.getValue());
    }

    public static HashMap<String, String> createMap() {
        //Напишите тут ваш код
        HashMap<String, String> people = new HashMap<String, String>();

        people.put("Ivanov", "Petr");
        people.put("Petrov", "Vasilij");
        people.put("Sidorov", "Sergey");
        people.put("Smirnov", "Pyotr");
        people.put("Nemiroff", "Vasilij");
        people.put("Ivanova", "Sofia");
        people.put("Macalan", "John");
        people.put("Smirnoff", "John");
        people.put("Jameson", "John");
        people.put("Napoleone", "Buonaparte");

        return people;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //Напишите тут ваш код
        List<String> keys = new ArrayList<String>();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair1 = it.next();
            String name = pair1.getValue();
            String key = pair1.getKey();
            for (Map.Entry<String, String> pair : map.entrySet()) {
                if (name.equals(pair.getValue()) & !key.equals(pair.getKey())) keys.add(pair.getKey());
            }
        }
        for (String x : keys) map.remove(x);

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
