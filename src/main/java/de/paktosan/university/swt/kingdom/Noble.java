package de.paktosan.university.swt.kingdom;

public class Noble extends Inhabitant {
    @Override
    public int tax() {
        var toPay = super.tax();
        if (toPay < 20) {
            return 20;
        } else {
            return toPay;
        }
    }
}
