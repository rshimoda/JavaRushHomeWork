package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }

    @Override
    public void write(int c) throws IOException {
        try {
            System.out.println((char) c);
        }
        catch (Exception e) {
            //NOP
        }
        super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        try {
            System.out.println(String.valueOf(cbuf, off, len));
        }
        catch (Exception e) {
            //NOP
        }
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        try {
            System.out.println(str.substring(off, off + len));
        }
        catch (Exception e) {
            //NOP
        }
        super.write(str, off, len);
    }


    @Override
    public void write(char[] cbuf) throws IOException {
//        try {
//            System.out.println(String.valueOf(cbuf));
//        }
//        catch (Exception e) {
//            //NOP
//        }
        super.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException {
//        try {
//            System.out.println(str);
//        }
//        catch (Exception e) {
//            //NOP
//        }
        super.write(str);
    }

    public static void main(String[] args) throws IOException {
        FileConsoleWriter writer = new FileConsoleWriter("/Users/sergey/1.txt");

        writer.write(new char[]{'a', 'b', 'c'});
        writer.write(new char[]{'a', 'b', 'c'}, 1, 2);
        writer.write(0160);
        writer.write("Bienbenidas!");
        writer.write("Bienbenidas", 4, 2);
    }
}
