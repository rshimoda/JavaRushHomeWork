package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение, вывести в консоль переданное неправильное имя файла и завершить работу программы
Не забудьте закрыть все потоки
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        read(scanner);
    }

    static void read(Scanner scanner) {

        String fileName = scanner.nextLine();
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedReader.close();
            read(scanner);
        }
        catch (FileNotFoundException e)
        {
            System.out.print(fileName);
        }
        catch (IOException e)
        {
            //NOP
        }
        finally
        {
            scanner.close();
        }
    }
}
