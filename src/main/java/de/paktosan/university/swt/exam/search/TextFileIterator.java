package de.paktosan.university.swt.exam.search;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TextFileIterator implements Iterator<String> {

    private Resource resource;
    private String text = "We wish you good luck in this exam!\nWe hope you are well pre-\npared.";
    private List<String> parts;
    private Iterator<String> iterator;
    private int count = 0;

    public TextFileIterator(Resource res) {
        if (res == null) throw new NullPointerException("Resource shall not be null!");
        this.resource = res;
        parts = Arrays.asList(text.replace("-\n", "").replace("\n", " ")
                .replaceAll("[^A-Za-z0-9 ]", "").split(" "));
        iterator = parts.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public String next() {
        return iterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Removing is not supprted!");
    }

    public String getAsString() {
        return text;
    }
}
