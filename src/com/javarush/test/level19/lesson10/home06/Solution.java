package com.javarush.test.level19.lesson10.home06;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();

        char table[][] = new char[n][m];
        int result = 0;
        LinkedList<int[]> d = new LinkedList<int[]>();
        for (int i = 0; i < n; i++)
        {
            table[i] = scanner.next().toCharArray();
            for (int j = 0; j < m; j++)
            {
                if (table[i][j] == 'D')
                {
                    int[] e = {i, j};
                    d.add(e);
                }
            }
        }
        scanner.close();
        if ((n * m) / 4 < 1)
        {
            System.out.println("Poor Dima!");
            return;
        }
        for (int[] x : d)
        {
            int count = 0;
            int a = x[0], b = x[1];
            while (true)
            {
                boolean wasLetter = false, hasAlternateI = false, hasAlternateM = false, hasAlternateA = false, hasAlternateD = false;
                if (!hasAlternateI && b + 1 < table[a].length && table[a][b + 1] == 'I')
                    {b += 1; wasLetter=true;}
                if (b - 1 >= 0 && table[a][b - 1] == 'I')
                    {if (!wasLetter) {b -= 1; wasLetter=true;} else hasAlternateI = true;}
                if (a + 1 < table.length && table[a + 1][b] == 'I')
                    {if (!wasLetter) {a += 1; wasLetter=true;} else hasAlternateI = true;}
                if (a - 1 > 0 && table[a - 1][b] == 'I')
                    {if (!wasLetter) {a -= 1; wasLetter=true;} else hasAlternateI = true;}
                if (!wasLetter) break;

                wasLetter = false;
                if (!hasAlternateM && b + 1 < table[a].length && table[a][b + 1] == 'M')
                    {b += 1; wasLetter=true;}
                if (b - 1 >= 0 && table[a][b - 1] == 'M')
                    {b -= 1; wasLetter=true;}
                if (a + 1 < table.length && table[a + 1][b] == 'M')
                    {a += 1; wasLetter=true;}
                if (a - 1 > 0 && table[a - 1][b] == 'M')
                    {a -= 1; wasLetter=true;}
                if (!wasLetter) break;

                wasLetter = false;
                if (!hasAlternateA && b + 1 < table[a].length && table[a][b + 1] == 'A')
                    {b += 1; wasLetter=true;}
                if (b - 1 >= 0 && table[a][b - 1] == 'A')
                    {b -= 1; wasLetter=true;}
                if (a + 1 < table.length && table[a + 1][b] == 'A')
                    {a += 1; wasLetter=true;}
                if (a - 1 > 0 && table[a - 1][b] == 'A')
                    {a -= 1; wasLetter=true;}
                if (!wasLetter) break;
                count++;

                wasLetter = false;
                if (!hasAlternateD && b + 1 < m && table[a][b + 1] == 'D')
                {b += 1; wasLetter=true;} else
                if (b - 1 >= 0 && table[a][b - 1] == 'D')
                {if (!wasLetter) {b -= 1; wasLetter=true;} else hasAlternateD = true;}
                if (a + 1 < n && table[a + 1][b] == 'D')
                {if (!wasLetter) {a += 1; wasLetter=true;} else hasAlternateD = true;}
                if (a - 1 > 0 && table[a - 1][b] == 'D')
                {if (!wasLetter) {a -= 1; wasLetter=true;} else hasAlternateD = true;}
                if (!wasLetter) {
                    if (hasAlternateI) {
                        if (b - 1 >= 0 && table[a][b - 1] == 'I')
                        {if (!wasLetter) {b -= 1; wasLetter=true;} else hasAlternateI = true;}
                        if (a + 1 < table.length && table[a + 1][b] == 'I')
                        {if (!wasLetter) {a += 1; wasLetter=true;} else hasAlternateI = true;}
                        if (a - 1 > 0 && table[a - 1][b] == 'I')
                        {if (!wasLetter) {a -= 1; wasLetter=true;} else hasAlternateI = true;}
                    }


                    break;
                }


                if (count > result) result = count;

            }
        }
        if (result > (n * m) / 4)
        {
            System.out.println("Poor Inna!");
            return;
        }
        if (result == 0)
        {
            System.out.println("Poor Dima!");
            return;
        }

        System.out.println(result);
    }
}
