package com.javarush.test.level19.lesson10.home03;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws FileNotFoundException, ParseException
    {
        Scanner scanner = new Scanner(new File(args[0]));

        while (scanner.hasNext())
        {
            StringBuilder name = new StringBuilder();
            StringBuilder date = new StringBuilder();
            while(!scanner.hasNextInt())
                name.append(scanner.next()).append(" ");
            if(name.toString().endsWith(" ")) name.deleteCharAt(name.length() - 1);
            date.append(scanner.nextInt()).append(" ").append(scanner.nextInt()).append(" ").append(scanner.nextInt());

            Date dateFormat = new SimpleDateFormat("dd MM yyyy").parse(date.toString());
            PEOPLE.add(new Person(name.toString(), dateFormat));
        }
        scanner.close();

        //System.out.print(PEOPLE.get(0).getName() + " " + PEOPLE.get(0).getBirthday());
    }

}
