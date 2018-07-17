package de.paktosan.university.swt.exam.parts;

public class Factory {
    private ReceivingStock stock;
    private Purchasing purchasing;

    public Factory(Purchasing purchasing, ReceivingStock stock) {
        if (purchasing==null||stock==null) throw new NullPointerException("Arguments shall not be null!");
        this.stock = stock;
        this.purchasing = purchasing;
    }

    public ReceivingStock getStock() {
        return stock;
    }

    public Purchasing getPurchasing() {
        return purchasing;
    }

    public static Part create(PartType type, String id, String name) {
        if (type == null || id == null || name == null) throw new NullPointerException("Arguments shall not be null!");
        if (id.isEmpty()||name.isEmpty()) throw new IllegalArgumentException("Name or ID shall not be empty!");
        switch (type) {
            case RESOURCE:
                return new Resource(id, name);
            case COMPONENTS:
                return new Components(id, name);
            case SINGLE_COMPONENT:
                return new SingleComponent(id, name);
            //this is horrible
            default:
                return null;
        }
    }
}
