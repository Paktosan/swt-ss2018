package de.paktosan.university.swt.exam.projects;

public abstract class ProjectItem {
    private String name;
    private String details;
    private double rate;

    public ProjectItem(String name, String details, double rate) {
        if (name == null | details == null) throw new NullPointerException("Arguments shall not be null!");
        if (name.isEmpty() || details.isEmpty()) throw new IllegalArgumentException("Arguments shall not be empty!");
        if (rate < 0) throw new IllegalArgumentException("Rate has to be positive!");
        this.name = name;
        this.details = details;
        this.rate = rate;
    }

    public void setDetails(String details) {
        if (details == null) throw new NullPointerException("Details shall not be null!");
        if (details.isEmpty()) throw new IllegalArgumentException("Details shall not be empty!");
        this.details = details;
    }

    public long getCostEstimate() {
        return Math.round(getTimeRequired() * rate) + getMaterialCost();
    }

    public abstract double getTimeRequired();

    public abstract long getMaterialCost();
}
