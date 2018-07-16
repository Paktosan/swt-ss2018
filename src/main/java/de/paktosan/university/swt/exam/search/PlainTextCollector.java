package de.paktosan.university.swt.exam.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlainTextCollector implements KeywordCollector {
    @Override
    public Set<String> getKeywords(Resource res) {
        if (res == null) throw new NullPointerException("Resource shall not be null!");
        TextFileIterator iterator = new TextFileIterator(res);
        Set<String> keywords = new HashSet<>();
        while (iterator.hasNext()){
            keywords.add(iterator.next());
        }
        return keywords;
    }
}
