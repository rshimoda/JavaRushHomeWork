package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("RiDD", new Date("JANUARY 25 1992"));
        map.put("Machet1k", new Date("AUGUST 27 1992"));
        map.put("mama", new Date("JUNE 29 1971"));
        map.put("papa", new Date("APRIL 17 1969"));
        map.put("baba", new Date("NOVEMBER 1 1936"));
        map.put("deda", new Date("AUGUST 29 1933"));
        map.put("Michael Jackson", new Date("AUGUST 29 1958"));
        map.put("Anna", new Date("March 7 1991"));
        map.put("SLI1GHT", new Date("March 18 1992"));
        map.put("Aaron Paul", new Date("AUGUST 27 1979"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth() + 1;
            if (6 <= month && month <= 8) {
                iterator.remove();
            }
        }

    }
}
