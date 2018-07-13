package de.paktosan.university.swt.exam.auction;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Auction {
    private int nextItem;
    private boolean closed;
    private List<Person> bidders;
    private List<Item> allItems;

    public Auction() {
        nextItem = 1;
        closed = false;
        bidders = new ArrayList<>();
        allItems = new ArrayList<>();
    }

    public void addBid(String itemName, String nameOfBidder, long price) {
        if (itemName.equals("")) {
            throw new IllegalArgumentException("Item name shall not be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price has to positive!");
        }
        Person bidder = bidders.stream().filter(person -> person.getName().toLowerCase().equals(nameOfBidder.toLowerCase()))
                .findAny().orElse(new Person(nameOfBidder));
        if (!bidders.contains(bidder)) {
            bidders.add(bidder);
        }
        Item item = allItems.stream().filter(item1 -> item1.getName().toLowerCase().equals(itemName.toLowerCase()))
                .findAny().get();
        item.addBid(bidder, price);
    }

    //required because the test wants to create a new item using an integer despite the UML says it shall be a Long
    public void addBid(String itemName, String nameOfBidder, int price) {
        if (closed) throw new IllegalStateException("Auction already closed!");
        addBid(itemName, nameOfBidder, Long.valueOf(price));
    }

    public void registerItem(Item item) {
        if (closed) throw new IllegalStateException("Auction already closed!");
        if (item == null) throw new NullPointerException("Item should not be null!");
        if (allItems.stream().anyMatch(item1 -> item.getName().equals(item1.getName()))) {
            throw new IllegalArgumentException("This item is already in the auction!");
        }
        allItems.add(item);
    }

    public String closeAuction() {
        if (closed) throw new IllegalStateException("Auction already closed!");
        closed = true;
        return generateItemListString();
    }

    public List<Item> getAllItems() {
        return allItems;
    }

    public String generateItemListString() {
        StringBuilder sb = new StringBuilder();
        allItems.forEach(item -> sb.append(generateItemString(item) + "\n"));
        return sb.toString();
    }

    public abstract String generateItemString(Item item);

    public String generateAllBidsString(Item item) {
        StringBuilder sb = new StringBuilder();
        sb.append("All bids:");
        item.getAllBids().forEach(bid -> sb.append("\n"+bid.toString()));
        return sb.toString();
    }
}
