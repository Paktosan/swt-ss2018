package de.paktosan.university.swt.exam.parts;

public class ReceivingStock extends Stock {
    private int minStockItems;
    private int maxStockItems;

    public ReceivingStock(int minStockItems, int maxStockItems) {
        super();
        if (minStockItems < 1) throw new IllegalArgumentException("minStockItems has to be at least 1!");
        if (maxStockItems < minStockItems) throw new IllegalArgumentException("maxStockItems has to be larger than minStockItems!");
        this.minStockItems = minStockItems;
        this.maxStockItems = maxStockItems;
    }

    public int getMinStockItems() {
        return minStockItems;
    }

    public int getMaxStockItems() {
        return maxStockItems;
    }

    @Override
    public boolean set(Part part, int count) {
        var toReturn = super.set(part, count);
        if (super.get(part) < minStockItems) {
            notify(part);
        }
        return toReturn;
    }

    @Override
    public boolean delete(Part part, int count) {
        var toReturn = super.delete(part, count);
        if (super.get(part) < minStockItems) {
            notify(part);
        }
        return toReturn;
    }
}
