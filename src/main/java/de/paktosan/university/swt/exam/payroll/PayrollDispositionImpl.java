package de.paktosan.university.swt.exam.payroll;

import java.util.HashMap;
import java.util.Map;

public class PayrollDispositionImpl implements PayrollDisposition {
    private Map<Employee, Double> payments;

    public PayrollDispositionImpl() {
        this.payments = new HashMap<>();
    }

    @Override
    public void sendPayment(Employee employee, double payment) {
        if (employee == null) throw new NullPointerException("Employee shall not be null!");
        if (payment <= 0) throw new IllegalArgumentException("Payment has to be positive!");
        payments.put(employee, payment);
    }

    public double getTotal() {
        double total = 0;
        for (Double payment : payments.values()) {
            total += payment;
        }
        return total;
    }

    public double getAverage() {
        if (payments.size() == 0) {
            return 0;
        } else {
            return getTotal() / payments.size();
        }
    }

    public Map<Employee, Double> getPayments() {
        return payments;
    }
}
