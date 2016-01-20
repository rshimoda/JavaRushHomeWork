package com.javarush.test.level17.lesson10.home03;

public class Drug {
    private String name;
    private String description;

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized String getDescription() {
        return description;
    }

    public synchronized void setDescription(String description) {
        this.description = description;
    }
}
