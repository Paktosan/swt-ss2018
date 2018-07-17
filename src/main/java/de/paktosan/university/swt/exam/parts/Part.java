package de.paktosan.university.swt.exam.parts;

public abstract class Part {
    private String id;
    private String name;

    public Part(String id, String name) {
        if (id==null||name==null) throw new NullPointerException("Arguments shall not be null!");
        if (id.isEmpty()||name.isEmpty()) throw new IllegalArgumentException("Arguments shall not be empty!");
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
