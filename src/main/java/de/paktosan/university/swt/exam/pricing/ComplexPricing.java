package de.paktosan.university.swt.exam.pricing;

import java.util.ArrayList;
import java.util.List;

public abstract class ComplexPricing implements ISalePricing{
    private List<ISalePricing> pricings = new ArrayList<>();

    public void add(ISalePricing pricing){
        pricings.add(pricing);
    }

    public List<ISalePricing> getPricings() {
        return pricings;
    }

    @Override
    public long getTotal(Sale sale) {
        return 0;
    }
}
