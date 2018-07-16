package de.paktosan.university.swt.exam.search;

import java.util.HashSet;
import java.util.Set;

public class DefaultCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {
        Set<String> keywords = new HashSet<>();
        keywords.add(res.getName());
        return keywords;
    }
}
