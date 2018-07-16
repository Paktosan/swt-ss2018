package de.paktosan.university.swt.exam.search;

import java.util.Set;

public interface KeywordCollector {
    Set<String> getKeywords(Resource res);
}
