package de.paktosan.university.swt.library;
/*
 * Lehrstuhl Softwaretechnologie, TU Dresden, Datei Library.java
 *
 * Library-Klasse implementiert eine Bibliothek,
 * die maximal 10 Bücher aufnehmen kann
 */


public class Library {

    private Book[] myBooks;

    private int number;

    public Library() {
        myBooks = new Book[10];
        number = 0;
        System.out.println("Hello, I am a library, which can store up to 10 books!");
    }

    public void add(Book book) {
        if (number < 10) {
            myBooks[number] = book;
            number += 1;
            System.out.println(String.format("I added the book %s!", book));
        } else {
            System.out.println("The library is full!");
        }
    }

    public Book search(String title) {
        for (Book book : myBooks) {
            if (book != null) {
                if (book.toString().equals(title)) {
                    System.out.println(String.format("The book with the title %s exists in the library!", title));
                    return book;
                }
            }
        }
        System.out.println(String.format("The book with the title %s does not exist in the library!", title));
        return null;
    }
}