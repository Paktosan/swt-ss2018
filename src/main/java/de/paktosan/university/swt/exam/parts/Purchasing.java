package de.paktosan.university.swt.exam.parts;

public class Purchasing implements Observation {
    private ReceivingStock stock;

    public Purchasing(ReceivingStock stock) {
        if (stock==null) throw new NullPointerException("Stock shall not be null!");
        this.stock = stock;
    }

    public ReceivingStock getStock() {
        return stock;
    }

    public void buy(Part part, int count) {
        stock.insert(part, count);
    }

    @Override
    public void alarm(Part part) {
        buy(part, stock.getMaxStockItems() - stock.get(part));
    }
}
