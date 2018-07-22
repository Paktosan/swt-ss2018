package de.paktosan.university.swt.exam.payroll;

public class Volunteer extends Employee{
    public Volunteer(String id) {
        super(id);
    }

    @Override
    public boolean isPayday(int dayOfMonth) {
        return false;
    }

    @Override
    public double calculatePay() throws UnpayableEmployeeException{
        throw new UnpayableEmployeeException("Employee is a volunteer!");
    }

    @Override
    public double calculateDeductions() {
        return 0;
    }
}
