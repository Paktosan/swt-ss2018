package de.paktosan.university.swt.exam.payroll;

public class Appointee extends Employee {
    private int dayOfMonth;
    private int hoursPerMonth;
    private double payPerHour;

    public Appointee(String id, int dayOfMonth, int hoursPerMonth, double payPerHour) {
        super(id);
        if (0 >= dayOfMonth || dayOfMonth > 31) throw new IllegalArgumentException("Payday is invalid!");
        if (hoursPerMonth <= 0) throw new IllegalArgumentException("Hours per month has to be positive!");
        if (payPerHour <= 0) throw new IllegalArgumentException("Payment per hour has to be positive!");
        this.dayOfMonth = dayOfMonth;
        this.hoursPerMonth = hoursPerMonth;
        this.payPerHour = payPerHour;
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        return (dayOfMonth == this.dayOfMonth);
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException {
        return hoursPerMonth * payPerHour;
    }

    @Override
    public double calculateDeductions() {
        double gross = 0;
        try {
            gross = calculatePay();
        } catch (UnpayableEmployeeException e) {
            e.printStackTrace();
        }
        return gross - gross * 0.6;
    }
}
