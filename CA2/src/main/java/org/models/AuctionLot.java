package org.models;

import org.utils.MyLinkedList;

import java.time.LocalDate;

public class AuctionLot {
    public String title;
    public String description;
    public String type;
    public LocalDate dateOfOrigin;
    public double askingPrice;
    public String image;

    public String dateOfSale;
    public double finalPrice;

    //auction lot identifier needed for hashing
    public int auctionLotIdentifier;

    public MyLinkedList<Bid> bidList = new MyLinkedList<>();

    public AuctionLot(String title, String description, String type, LocalDate dateOfOrigin, double askingPrice, String image) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.dateOfOrigin = dateOfOrigin;
        this.askingPrice = askingPrice;
        this.image = image;
    }


    //GETTERS AND SETTERS
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateOfOrigin() {
        return dateOfOrigin;
    }

    public double getAskingPrice() {
        return askingPrice;
    }

    public String getImage() {
        return image;
    }

    public void setAuctionLotIdentifier(int auctionLotIdentifier) {
        this.auctionLotIdentifier = auctionLotIdentifier;
    }


    //displays the title in the treeview
    @Override
    public String toString() {
        return title;
    }
}
