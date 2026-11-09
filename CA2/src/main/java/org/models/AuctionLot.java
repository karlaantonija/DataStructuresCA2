package org.models;

public class AuctionLot {
    public String title;
    public String description;
    public String type;
    public String dateOfOrigin;
    public double askingPrice;
    public String image;

    public String dateOfSale;
    public double finalPrice;

    public AuctionLot(String title, String description, String type, String dateOfOrigin, double askingPrice, String image) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.dateOfOrigin = dateOfOrigin;
        this.askingPrice = askingPrice;
        this.image = image;
    }
}
