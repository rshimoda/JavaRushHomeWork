package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран частоту встречания пробела. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
Закрыть потоки
*/

//import java.io.FileInputStream;
//import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Solution implements ActionListener {
    JLabel jLabel;

    Solution() {
        JFrame jFrame = new JFrame("Vidus 1.0");
        jFrame.setLayout(new FlowLayout()); // установка диспетчера компоновки

        jFrame.setSize(275, 100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jButtonStart = new JButton("Start");
        jButtonStart.addActionListener(this);

        jFrame.add(jButtonStart);
        jFrame.add(jLabel = new JLabel("<html><body align = \"center\"> Alpha </body></html>"));
        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getActionCommand().equals("Start"))
        {
            jLabel.setText("Now it's unavailable.");
        }
    }
    public static void main(String[] args) //throws IOException
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Solution();
            }
        });
        /*
        FileInputStream stream = new FileInputStream(args[0]);

        int n1 = stream.available();
        float n2 = 0;

        while (stream.available() > 0)
        {
            int b = stream.read();
            if(b == ' ') n2++;
        }
        stream.close();

        System.out.print(String.format("%.2f", (n2/n1)*100));
        */
    }
}
