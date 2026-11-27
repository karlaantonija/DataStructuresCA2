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


    //displays the name in the treeview
    @Override
    public String toString() {
        return name;
    }
}
