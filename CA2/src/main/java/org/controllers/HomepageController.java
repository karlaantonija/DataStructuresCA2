package org.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomepageController {

    //HOMEPAGE VARIABLES
    public Button addAuctionLotPageButton;
    public Button addBidderPageButton;

    //SCENE CHANGES METHODS
    public void addAuctionLotView(ActionEvent event) throws IOException {
        // Load the FXML file for the second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/AuctionLot.fxml"));
        // Create a new stage for the second scene
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        // Set the title for the second scene
        stage.setTitle("Add an Auction Lot");
        // Show the second scene
        stage.show();
    }

    public void addBidderView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/bidder.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Add a new Bidder");
        stage.show();
    }
}
