package de.paktosan.university.swt.library.sets;

import java.util.*;

public class Library {
    private Set<Book> stock;

    public Library() {
        this.stock = new HashSet<>();
    }

    public boolean insertBook(Book book){
        if (!stock.contains(book)){
            stock.add(book);
            return true;
        }else return false;
    }

    public Book searchForIsbn(String isbn){
        Iterator<Book> iterator = stock.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            if (book.getIsbn().equals(isbn)){
                return book;
            }
        }
        return null;
    }

    public Collection<Book> searchForAuthor(String author){
        Collection<Book> books = new HashSet<>();
        Iterator<Book> bookIterator = stock.iterator();
        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            if (book.getAuthor().equals(author)){
                books.add(book);
            }
        }
        return books;
    }

    public Map<String, Set<Book>> listStockByAuthor(){
        Map<String, Set<Book>> sortedBooks = new HashMap<>();
        Iterator<Book> bookIterator = stock.iterator();
        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            if (sortedBooks.containsKey(book.getAuthor())){
                sortedBooks.get(book.getAuthor()).add(book);
            }else {
                Set<Book> newBooks = new HashSet<>();
                newBooks.add(book);
                sortedBooks.put(book.getAuthor(), newBooks);
            }
        }
        return sortedBooks;
    }
}
