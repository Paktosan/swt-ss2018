package de.paktosan.university.swt.exam.pricing;

public class Sale {
    private long preDiscountTotal;
    private ISalePricing pricing;

    public Sale(long preDiscountTotal, ISalePricing pricing) {
        if (preDiscountTotal<0){
            throw new IllegalArgumentException("The total is negative!");
        }
        if (pricing==null){
            throw new NullPointerException("Pricing was null!");
        }
        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;
    }

    public long getPreDiscountTotal() {
        return preDiscountTotal;
    }

    public void setPricing(ISalePricing pricing) {
        if (pricing==null){
            throw new NullPointerException("Pricing is null!");
        }
        this.pricing = pricing;
    }

    public long getTotal() {
        return pricing.getTotal(this);
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold) {
        switch (discountType) {
            case ABSOLUTEDISCOUNT:
                return new AbsoluteDiscountPricing(discount, threshold);
            case PERCENTAGEDISCOUNT:
                return new PercentageDiscountPricing(percentage);
            default:
                return null;
        }
    }
}
