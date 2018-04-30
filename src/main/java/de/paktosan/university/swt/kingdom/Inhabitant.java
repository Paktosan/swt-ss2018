package de.paktosan.university.swt.kingdom;

public class Inhabitant {
    protected int income;

    public int taxableIncome() {
        return income;
    }

    public int tax() {
        var toPay = income * 0.1;
        if (toPay < 1) {
            return 1;
        } else {
            return (int) toPay;
        }
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
