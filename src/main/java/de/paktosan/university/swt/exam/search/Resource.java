package de.paktosan.university.swt.exam.search;

public class Resource {
    private String name;
    private String path;
    private ResourceType rt;

    public Resource(String name, String path, ResourceType rt) {
        if (name == null || path == null || rt == null) throw new NullPointerException("Arguments shall not be null!");
        if (name.isEmpty()||path.isEmpty()) throw new IllegalArgumentException("Name or path shall not be empty!");
        this.name = name;
        this.path = path;
        this.rt = rt;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public ResourceType getType() {
        return rt;
    }
}
