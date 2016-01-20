package com.javarush.test.level03.lesson06.task04;

/* Путь к файлу java.exe
Выведи на экран текст: полное имя файла java.exe из установленного пакета java
*/

public class Solution {
    public static void main(String[] args) {
        //Напишите тут ваш код
        char sh = '\\';
        String java = "C:" + sh + "Program Files" + sh + "Java" + sh + "jre1.7.0_25" + sh + "bin" + sh + "java.exe";
        System.out.print(java);
    }
}