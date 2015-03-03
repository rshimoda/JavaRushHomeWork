package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
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
            int argsSize = args.length - 1;
            int ind = 1;
            for(int i = 0; i < argsSize/3; i++)
            {
                    allPeople.add((args[ind + 1].equals("м") ? Person.createMale(args[ind], format.parse(args[ind + 2])) : Person.createFemale(args[ind], format.parse(args[ind + 2]))));
                    System.out.println(allPeople.size() - 1);
                    ind += 3;
            }
        }


        else if (args[0].equals("-u"))
        {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            int argsSize = args.length - 1;
            int ind = 1;
            for(int i = 0; i < argsSize/4; i++)
            {
                int id = Integer.parseInt(args[ind]);
                allPeople.get(id).setName(args[ind + 1]);
                allPeople.get(id).setSex(args[ind + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                allPeople.get(id).setBirthDay(format.parse(args[ind + 3]));

                ind += 4;
            }
        }


        else if (args[0].equals("-d"))
        {
            int ind = 1;
            for(int i = 0; i < args.length - 1; i++) {
                int id = Integer.parseInt(args[ind]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setSex(null);
                allPeople.get(id).setBirthDay(null);

                ind++;
            }
        }


        else if (args[0].equals("-i"))
        {
            int ind = 1;
            for(int i = 0; i < args.length - 1; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                int id = Integer.parseInt(args[ind]);
                stringBuilder.append(allPeople.get(id).getName()).append(" ");
                stringBuilder.append(allPeople.get(id).getSex().equals(Sex.MALE)?"м":"ж").append(" ");
                stringBuilder.append(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(id).getBirthDay()));

                System.out.println(stringBuilder.toString());

                ind++;
            }

        }
    }
}
