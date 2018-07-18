package de.paktosan.university.swt.exam.projects;

import java.util.ArrayList;
import java.util.List;

public class Adapter implements IProject{
    private Project project;

    public Adapter(String name, String description, double rate) {
        this.project = new Project(name, description, rate);
    }

    @Override
    public void setTask(Task newTask) {
        project.setTask(newTask);
    }

    @Override
    public double getDuration() {
        return project.getDuration();
    }

    @Override
    public long getTotalCost() {
        return project.getTotalCost();
    }

    @Override
    public List<Deliverable> getDeliverables() {
        List<Deliverable> deliverables = new ArrayList<>();
        project.allDeliverables().forEach(((calendar, deliverables1) -> deliverables1.parallelStream()
        .forEach(deliverables::add)));
        return deliverables;
    }
}
