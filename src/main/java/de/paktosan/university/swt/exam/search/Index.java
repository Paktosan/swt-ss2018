package de.paktosan.university.swt.exam.search;

import java.util.*;

public class Index {
    private Map<String, List<Resource>> index;

    public Index() {
        index = new HashMap<>();
    }

    public void add(Resource res){
        if (res==null) throw new NullPointerException("Resource shall not be null!");
        Set<String> keywords = res.getType().getCollector().getKeywords(res);
        for (String keyword : keywords){
            if (!index.containsKey(keyword)){
                index.put(keyword, new ArrayList<>());
            }
            if (!index.get(keyword).contains(res)){
                index.get(keyword).add(res);
            }
        }
    }

    public List<Resource> getResources(String keyword){
        if (keyword==null) throw new NullPointerException();
        return index.getOrDefault(keyword, new ArrayList<>());
    }
}
