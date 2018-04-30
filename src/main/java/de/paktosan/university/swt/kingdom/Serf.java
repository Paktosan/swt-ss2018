package de.paktosan.university.swt.kingdom;

public class Serf extends Peasant {
    @Override
    public int taxableIncome() {
        var toTax = super.taxableIncome() - 12;
        if (toTax < 0) {
            return 0;
        } else {
            return toTax;
        }
    }
}
