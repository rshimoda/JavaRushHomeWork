package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
/*
    public static void main(String[] args)
    {
        IncomeData incomeData = new IncomeData()
        {
            @Override
            public String getCountryCode()
            {
                return "UA";
            }

            @Override
            public String getCompany()
            {
                return "JavaRush";
            }

            @Override
            public String getContactFirstName()
            {
                return "Sergey";
            }

            @Override
            public String getContactLastName()
            {
                return "Popov";
            }

            @Override
            public int getCountryPhoneCode()
            {
                return 38;
            }

            @Override
            public int getPhoneNumber()
            {
                return 0;
            }
        };

        Contact contact = new IncomeDataAdapter(incomeData);

        System.out.print(contact.getPhoneNumber());
    }
*/
    public static class IncomeDataAdapter implements Customer, Contact{

        IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData)
        {
            this.incomeData = incomeData;
        }

        @Override
        public String getName()
        {
            return incomeData.getContactFirstName() + ", " + incomeData.getContactLastName();
        }

        @Override
        public String getPhoneNumber()
        {
            StringBuilder stringBuilder = new StringBuilder();
            int num = incomeData.getPhoneNumber();
            stringBuilder.append(incomeData.getCountryPhoneCode()).append(num);

            if (stringBuilder.length() < 12)
                for(int i = 12 - stringBuilder.length(); i > 0; i--)
                    stringBuilder.insert(String.valueOf(incomeData.getCountryPhoneCode()).length(), 0);

            int insertIndex = String.valueOf(incomeData.getCountryPhoneCode()).length();
            stringBuilder.insert(0, "+");
            stringBuilder.insert(insertIndex + 1, "(");
            stringBuilder.insert(insertIndex + 1 + 1 + 3 , ")");
            stringBuilder.insert(insertIndex + 1 + 1 + 3 + 1 + 3 , "-");
            stringBuilder.insert(insertIndex + 1 + 1 + 3 + 1 + 3 + 1 + 2, "-");

            if(stringBuilder.toString().endsWith("-")) stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            return stringBuilder.toString();
        }

        @Override
        public String getCompanyName()
        {
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(incomeData.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        int getCountryPhoneCode();      //example 38
        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}