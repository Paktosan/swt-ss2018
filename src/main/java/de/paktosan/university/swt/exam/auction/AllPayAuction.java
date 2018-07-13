package de.paktosan.university.swt.exam.auction;

public class AllPayAuction extends Auction {
    @Override
    public String generateItemString(Item item) {
        StringBuilder sb = new StringBuilder();
        sb.append(item.toString()+"\n");
        if (item.getAllBids().size()!=0) {
            sb.append(String.format("Highest bid: %s\n", item.getHighestBid().toString()));
            sb.append(generateAllBidsString(item));
        }else{
            sb.append("No bids placed");
        }
        return sb.toString();
    }
}
