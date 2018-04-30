package de.paktosan.university.swt.library.collections;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {

    private List<Book> stock;


    public Library() {
        stock = new ArrayList<>();
    }

    public void sortedInsertion(Book book) {
        stock.add(book);
    }

    public Book searchForIsbn(String isbn) {
        if (stock.isEmpty()) {
            return null;
        }
        stock.sort(null);
        var index = Collections.binarySearch(stock, new Book(isbn), null);
        if (index < 0) {
            return null;
        } else {
            return stock.get(index);
        }
    }

    public Collection<Book> searchForAuthor(String author) {
        return stock.stream().parallel().filter((book -> book.getAuthor().equalsIgnoreCase(author))).collect(Collectors.toList());
    }
}