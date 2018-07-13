package de.paktosan.university.swt.exam.auction;

import java.util.*;

public class Item {
    private String name;
    private String description;
    private Long minPrice;
    private List<Bid> allBids;
    private Bid highestBid;

    public Item(String name, String description, Long minPrice) {
        if (name == null || description == null) {
            throw new NullPointerException("Arguments should not be null!");
        }
        if (minPrice <= 0) {
            throw new IllegalArgumentException("Price has to be positive!");
        }
        if (name.equals("") || description.equals("")) {
            throw new IllegalArgumentException("Name or description should not be empty!");
        }
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
        allBids = new ArrayList<>();
    }

    //required because the test wants to create a new item using an integer despite the UML says it shall be a Long
    public Item(String name, String description, int minPrice) {
        this(name, description, Long.valueOf(minPrice));
    }

    public void addBid(Person bidder, long price) {
        if (price<=0){
            throw new IllegalArgumentException("Price has to be positive!");
        }
        if (price < minPrice) {
            return;
        } else if (highestBid != null) {
            if (price <= highestBid.getPrice()) {
                return;
            }
        }
        Bid bid = new Bid(bidder, price);
        if (highestBid == null || highestBid.getPrice() < price) {
            highestBid = bid;
        }
        allBids.add(bid);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Bid> getAllBids() {
        return allBids;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public String toString() {
        return String.format("%s: %s (minimum bidding price: %d EUR)", getName(), getDescription(), minPrice);
    }
}
