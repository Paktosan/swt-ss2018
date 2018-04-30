package de.paktosan.university.swt.taxi;

public class Human {
    private String forename;
    private String name;

    public Human(String forename, String name) {
        this.forename = forename;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getForename() {
        return forename;
    }

    public String toString() {
        return getForename() + " " + getName();
    }
}
