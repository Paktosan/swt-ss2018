package de.paktosan.university.swt.exam.search;

public class ResourceType {
    private String description;
    private KeywordCollector collector;

    public ResourceType(String desc, KeywordCollector collector) {
        if (desc == null || collector == null) throw new NullPointerException("Arguments shall not be null!");
        if (desc.isEmpty()) throw new IllegalArgumentException("Description shall not be empty!");
        this.description = desc;
        this.collector = collector;
    }

    public String getDescription() {
        return description;
    }

    public KeywordCollector getCollector() {
        return collector;
    }
}
