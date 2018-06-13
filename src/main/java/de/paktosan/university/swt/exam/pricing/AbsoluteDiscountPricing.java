package de.paktosan.university.swt.exam.pricing;

public class AbsoluteDiscountPricing implements ISalePricing {

    private long discount;
    private long threshold;

    public AbsoluteDiscountPricing(long discount, long threshold) {
        if(discount<0){
            throw new IllegalArgumentException("Discount is negative!");
        }
        if (threshold<0){
            throw new IllegalArgumentException("Threshold is negative!");
        }
        this.discount = discount;
        this.threshold = threshold;
    }

    @Override
    public long getTotal(Sale sale) {
        if(sale.getPreDiscountTotal()-discount>threshold){
            return sale.getPreDiscountTotal()-discount;
        }else if(threshold<sale.getPreDiscountTotal()){
            return threshold;
        }else return sale.getPreDiscountTotal();
    }
}
