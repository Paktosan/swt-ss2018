package de.paktosan.university.swt.exam.projects;

import java.util.*;

public class Project {
    private String name;
    private String description;
    private Task mainTask;

    public Project(String name, String description, double rate) {
        if (name == null || description == null) throw new NullPointerException("Arguments shall not be null!");
        if (name.isEmpty() || description.isEmpty())
            throw new IllegalArgumentException("Name or description shall not be empty!");
        this.name = name;
        this.description = description;
        this.mainTask = new Task(name, description, rate);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setTask(Task mainTask) {
        if (mainTask == null) throw new NullPointerException("Task shall not be null!");
        this.mainTask = mainTask;
    }

    public double getDuration() {
        return mainTask.getTimeRequired();
    }

    public long getTotalCost() {
        return mainTask.getCostEstimate();
    }

    public Map<Calendar, List<Deliverable>> allDeliverables() {
        Map<Calendar, List<Deliverable>> deliverables = new HashMap<>();
        mainTask.allDeliverables().forEach(deliverable -> {
            if (!deliverables.containsKey(deliverable.getDate())) {
                deliverables.put(deliverable.getDate(), new ArrayList<>());
            }
            var newList = deliverables.get(deliverable.getDate());
            newList.add(deliverable);
            deliverables.replace(deliverable.getDate(), newList);
        });
        return deliverables;
    }
}
