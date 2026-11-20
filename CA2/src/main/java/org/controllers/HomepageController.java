package org.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import org.example.App;

import java.io.IOException;

public class HomepageController {

    //HOMEPAGE VARIABLES
    public Button addAuctionLotPageButton;
    public Button addBidderPageButton;

    //SCENE CHANGES METHODS
    public void addAuctionLotView(ActionEvent event) throws IOException {
        App.setRoot("AuctionLot");
    }

    public void addBidderView(ActionEvent event) throws IOException {
       App.setRoot("bidder");
    }
}
