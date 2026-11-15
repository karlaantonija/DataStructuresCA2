package org.controllers;

import org.models.AuctionLot;
import org.models.Bidder;
import org.utils.MyLinkedList;

public class AuctionLotSystemAPI {

    private final MyLinkedList<AuctionLot> auctionLotList = new MyLinkedList<>();
    private final MyLinkedList<Bidder> bidderList = new MyLinkedList<>();

    //auction lot identifier needed for hashing
    private int nextAuctionLotId = 1;
    private int nextBidderId = 1;

    public MyLinkedList<AuctionLot> getAuctionLots()    { return auctionLotList; }
    public MyLinkedList<Bidder> getBidders()     { return bidderList; }

    //ADDING METHODS
    public void addAuctionLot(AuctionLot a) {
        a.setAuctionLotIdentifier(nextAuctionLotId++);
        auctionLotList.insert(a);
    }

    public void addBidder(Bidder b) {
        b.setBidderIdentifier(nextBidderId++);
        bidderList.insert(b);
    }
}