package org.models;

public class Bid {
    public double amount;
    public String dateOfBid;

    public Bid(double amount, String dateOfBid) {
        this.amount = amount;
        this.dateOfBid = dateOfBid;
    }


    //GETTERS AND SETTERS
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateOfBid() {
        return dateOfBid;
    }

    public void setDateOfBid(String dateOfBid) {
        this.dateOfBid = dateOfBid;
    }
}
