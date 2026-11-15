package org.models;

public class Bidder {
    public String name;
    public String address;
    public String telephone;
    public String email;

    public int bidderIdentifier;



    public Bidder(String name, String address, String telephone, String email) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    //GETTERS AND SETTERS
    public void setBidderIdentifier(int bidderIdentifier) {
        this.bidderIdentifier = bidderIdentifier;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
