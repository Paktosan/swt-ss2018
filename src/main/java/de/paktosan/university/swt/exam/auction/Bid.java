package de.paktosan.university.swt.exam.auction;

public class Bid {
    private long price;
    private Person bidder;

    public Bid(Person bidder, long price) {
        if (bidder == null) {
            throw new NullPointerException("Bidder should not be null!");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price has to be positive!");
        }
        this.price = price;
        this.bidder = bidder;
    }

    //required because the test wants to create a new item using an integer despite the UML says it shall be a Long
    public Bid(Person bidder, int price) {
        this(bidder, Long.valueOf(price));
    }

    public long getPrice() {
        return price;
    }

    public Person getBidder() {
        return bidder;
    }

    public String toString() {
        return String.format("%d EUR by %s", getPrice(), getBidder().toString());
    }
}
