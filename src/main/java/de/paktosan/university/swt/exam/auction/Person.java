package de.paktosan.university.swt.exam.auction;

public class Person {
    private String name;

    public Person(String name) {
        if (name == null) {
            throw new NullPointerException("Name is null!");
        } else if (name.equals("")) {
            throw new IllegalArgumentException("Name is empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }
}
