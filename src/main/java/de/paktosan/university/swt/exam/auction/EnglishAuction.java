package de.paktosan.university.swt.exam.auction;

public class EnglishAuction extends Auction {
    @Override
    public String generateItemString(Item item) {
        StringBuilder sb = new StringBuilder();
        sb.append(item.toString()+"\n");
        if (item.getAllBids().size()==0){
            sb.append("No bids placed");
        }else{
            sb.append(String.format("Highest bid: %s", item.getHighestBid().toString()));
        }
        return sb.toString();
    }
}
