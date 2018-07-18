package de.paktosan.university.swt.exam.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task extends ProjectItem {
    private List<ProjectItem> projectItems;

    public Task(String name, String details, double rate) {
        super(name, details, rate);
        projectItems = new ArrayList<>();
    }

    @Override
    public double getTimeRequired() {
        double time = 0;
        for (ProjectItem item : projectItems) {
            time += item.getTimeRequired();
        }
        return time;
    }

    @Override
    public long getMaterialCost() {
        long cost = 0;
        for (ProjectItem item : projectItems) {
            cost += item.getMaterialCost();
        }
        return cost;
    }

    public void addProjectItem(ProjectItem item) {
        if (item == null) throw new NullPointerException("ProjectItem shall not be null!");
        projectItems.add(item);
    }

    public void removeProjectItem(ProjectItem item) {
        if (item == null) throw new NullPointerException("ProjectItem shall not be null!");
        projectItems.remove(item);
    }

    public List<Deliverable> allDeliverables() {
        List<Deliverable> deliverables = new ArrayList<>();
        projectItems.forEach(item -> {
            if (item instanceof Deliverable) {
                deliverables.add((Deliverable) item);
            } else {
                deliverables.addAll(((Task) item).allDeliverables());
            }
        });
        return deliverables;
    }
}
