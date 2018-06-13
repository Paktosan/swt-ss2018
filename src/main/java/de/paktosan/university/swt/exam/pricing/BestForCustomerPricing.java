package de.paktosan.university.swt.exam.pricing;

import java.util.List;

public class BestForCustomerPricing extends ComplexPricing {

    public BestForCustomerPricing(ISalePricing pricing) {
        if (pricing == null){
            throw new NullPointerException("Pricing is null!");
        }
        add(pricing);
    }

    @Override
    public long getTotal(Sale sale) {
        final long[] currentTotal = {sale.getPreDiscountTotal()};
        getPricings().forEach(pricing -> {
            long potentialTotal = pricing.getTotal(sale);
            if (potentialTotal < currentTotal[0]) {
                currentTotal[0] = potentialTotal;
            }
        });
        return currentTotal[0];
    }
}
