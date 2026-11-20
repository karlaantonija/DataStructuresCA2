package org.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.App;
import org.models.Bidder;
import javafx.scene.control.Button;

import java.io.IOException;

public class BidderController {

    public TextField BidderNameField;
    public TextField BidderAddressField;
    public TextField BidderPhoneField;
    public TextField BidderEmailField;
    public Button BidderAddButton;
    public Button backButton;

    //ADDING METHODS
    public void addBidder(ActionEvent event) {

        Bidder bidder = new Bidder(
                BidderNameField.getText(),
                BidderAddressField.getText(),
                BidderPhoneField.getText(),
                BidderEmailField.getText()
        );

        App.auctionLotSystemAPI.addBidder(bidder);
        System.out.println("Bidder Added");
    }

    public void backButtonClick(ActionEvent actionEvent) throws IOException {
        App.setRoot("homepage");
    }
}
