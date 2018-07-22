package de.paktosan.university.swt.exam.payroll;

public class Payroll {
    private int payday;
    private PayrollDisposition disposition;

    public Payroll(PayrollDisposition disposition, int payday) {
        if (disposition == null) throw new NullPointerException("Disposition shall not be null!");
        if (payday < 1 || payday > 31) throw new IllegalArgumentException("Payday is not in allowed range!");
        this.payday = payday;
        this.disposition = disposition;
    }

    public void doPayroll(PayrollDB db) {
        db.getEmployeeList().parallelStream().filter(employee -> employee instanceof Appointee)
                .filter(employee -> employee.isPayday(payday)).forEach(employee -> {
            try {
                disposition.sendPayment(employee, employee.calculatePay() - employee.calculateDeductions());
            } catch (UnpayableEmployeeException e) {
                e.printStackTrace();
            }
        });
    }
}
