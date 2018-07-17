package de.paktosan.university.swt.exam.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Stock {
    private List<Observation> observers;
    private Map<Part, Integer> parts;

    public Stock() {
        this.observers = new ArrayList<>();
        this.parts = new HashMap<>();
    }

    public int get(Part part) {
        if (part == null) throw new NullPointerException("Part shall not be null!");
        return parts.getOrDefault(part, -1);
    }

    public boolean set(Part part, int count) {
        if (part == null) throw new NullPointerException("Part shall not be null!");
        if (count < 0) return false;
        if (parts.containsKey(part)) {
            parts.replace(part, count);
            return true;
        } else return false;
    }

    public void insert(Part part, int count) {
        if (part == null) throw new NullPointerException("Part shall not be null!");
        if (count <= 0) throw new IllegalArgumentException("It only makes sense to insert one or more!");
        if (parts.containsKey(part)) {
            parts.replace(part, parts.get(part) + count);
        } else parts.put(part, count);
    }

    public boolean delete(Part part, int count) {
        if (part == null) throw new NullPointerException("Part shall not be null!");
        if (!parts.containsKey(part) || count <= 0 || parts.get(part) < count) {
            return false;
        } else {
            parts.replace(part, parts.get(part) - count);
            return true;
        }
    }

    public void register(Observation observer) {
        if (observer == null) throw new NullPointerException("Observer shall not be null!");
        observers.add(observer);
    }

    public void notify(Part part) {
        observers.parallelStream().forEach(observer -> observer.alarm(part));
    }
}
