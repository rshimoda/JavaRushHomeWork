package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inputStream1 = new BufferedReader(new FileReader(reader.readLine()));
            BufferedReader inputStream2 = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();

            while (inputStream1.ready())
            {
                allLines.add(inputStream1.readLine());
            }
            inputStream1.close();

            while (inputStream2.ready())
            {
                forRemoveLines.add(inputStream2.readLine());
            }
            inputStream2.close();


            new Solution().joinData();
        }
        catch(CorruptedDataException e)
        {
            //allLines.clear();
        }
        catch (IOException e)
        {
            //NOP
        }
    }

    public void joinData() throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
