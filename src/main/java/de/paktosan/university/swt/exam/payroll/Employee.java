package de.paktosan.university.swt.exam.payroll;

public abstract class Employee {
    private String id;

    public Employee(String id) {
        if (id==null) throw new NullPointerException("ID shall not be null!");
        if (id.isEmpty()) throw new IllegalArgumentException("ID shall not be empty!");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract boolean isPayday(int dayOfMonth);

    public abstract double calculatePay() throws UnpayableEmployeeException;

    public abstract double calculateDeductions();
}
