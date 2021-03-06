package com.javarush.test.level16.lesson10.task04;

/* А без interrupt слабо?
Разберись, как работает программа.
Сделай так, чтобы в методе ourInterruptMethod можно было сделать так, чтобы нить TestThread завершилась сама.
Нельзя использовать метод interrupt.
*/

public class Solution {
    static boolean isInterrupted = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        //Add your code here - добавьте код тут
        isInterrupted = true;
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (!isInterrupted) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                }
            }
        }
    }
}
