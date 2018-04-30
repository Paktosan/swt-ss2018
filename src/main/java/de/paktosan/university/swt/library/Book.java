package de.paktosan.university.swt.library;

public class Book {

    private String title;

    public Book(String title) {
        this.title = title;
        System.out.println(String.format("Book %s created.", title));
    }

    public String toString() {
        return title;
    }
}
