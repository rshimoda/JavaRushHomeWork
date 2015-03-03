package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        if(args[0].equals("-c"))
        {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            if(args.length == 4)
            {
                allPeople.add((args[2].equals("м") ? Person.createMale(args[1], format.parse(args[3])) : Person.createFemale(args[1], format.parse(args[3]))));
                System.out.print(allPeople.size() - 1);
            }
            if (args.length == 5)
            {
                allPeople.add((args[3].equals("м") ? Person.createMale(args[1] + args[2], format.parse(args[4])) : Person.createFemale(args[1] + args[2], format.parse(args[4]))));
                System.out.print(allPeople.size() - 1);
            }
        }


        else if (args[0].equals("-u"))
        {
            if (args.length == 5)
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(args[2]);
                allPeople.get(id).setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                allPeople.get(id).setBirthDay(format.parse(args[4]));
            }
        }


        else if (args[0].equals("-d"))
        {
            if (args.length == 2)
            {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);
            }
        }


        else if (args[0].equals("-i"))
        {
            if (args.length == 2)
            {
                StringBuilder stringBuilder = new StringBuilder();
                int id = Integer.parseInt(args[1]);
                stringBuilder.append(allPeople.get(id).getName()).append(" ");
                stringBuilder.append(allPeople.get(id).getSex().equals(Sex.MALE)?"м":"ж").append(" ");
                stringBuilder.append(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(id).getBirthDay()));

                System.out.print(stringBuilder.toString());
            }

        }
    }
}
