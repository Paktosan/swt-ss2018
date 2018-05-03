package de.paktosan.university.swt.library.collections;

public class Book implements Comparable<Book> {

    private String title;
    private String isbn;
    private String author;

    public Book(String isbn) {
        this.isbn = isbn;
        author = "";
        title = "";
    }

    public Book(String isbn, String author, String title) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    @Override
    public int compareTo(Book otherBook) {
        return isbn.compareTo(otherBook.getIsbn());
    }
}
