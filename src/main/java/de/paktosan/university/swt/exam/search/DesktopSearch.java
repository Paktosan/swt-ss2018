package de.paktosan.university.swt.exam.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesktopSearch {
    private Map<String, ResourceType> types;
    private Index index;

    public DesktopSearch() {
        index = new Index();
        types = new HashMap<>();
    }

    public void registerType(String extension, ResourceType type){
        if (type==null||extension==null) throw new NullPointerException("Arguments shall not be null!");
        types.put(extension, type);
    }

    public ResourceType getType(String extension){
        return types.get(extension);
    }

    public void unregisterType(String extension){
        if (extension==null) throw new NullPointerException("Extension shall not be null!");
        types.remove(extension);
    }

    public void registerResource(Resource res){
        index.add(res);
    }

    public List<Resource> processRequest(String request){
        return index.getResources(request);
    }
}
