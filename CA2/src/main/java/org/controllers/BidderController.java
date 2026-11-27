package org.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.App;
import org.models.AuctionLot;
import org.models.Bid;
import org.models.Bidder;
import org.utils.MyIterator;

import java.io.IOException;

public class BidderController {

    public TextField BidderNameField;
    public TextField BidderAddressField;
    public TextField BidderPhoneField;
    public TextField BidderEmailField;
    public Button BidderAddButton;
    public Button backButton;
    public VBox bidderVbox;
    public TreeView<Object> bidderTreeView;
    public TextArea bidderDetailsArea;


    @FXML
    public void initialize() {


        //for TreeView. If statement is necessary because this controller is used by homepage.fxml too, and it doesn't have a treeView.
        //It allows the user to select a campsite they added, so that they can add a bidder lot to it.
        if (bidderTreeView != null) {
            TreeItem<Object> rootItem = new TreeItem<>("Bidders");
            rootItem.setExpanded(true);


            bidderTreeView.setRoot(rootItem);

            bidderTreeView.getSelectionModel()
                    .selectedItemProperty()
                    .addListener((obs, oldItem, newItem) -> {

                        if (newItem != null) {
                            System.out.println("Selected: "
                                    + newItem.getValue());
                        }
                    });

        }
    }

    //SELECTING
    public void selectItem() {
        TreeItem<Object> item = bidderTreeView.getSelectionModel().getSelectedItem();

        if (item != null) {
            System.out.println(item.getValue());
        }
    }

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
        refreshTree();

        BidderNameField.clear();
        BidderAddressField.clear();
        BidderPhoneField.clear();
        BidderEmailField.clear();
    }

    private void refreshTree() {
        if (bidderTreeView == null) return;

        TreeItem<Object> root = new TreeItem<>("Bidders");
        root.setExpanded(true);

        MyIterator<Bidder> it = App.auctionLotSystemAPI.getBidders().iterator();
        while (it.hasNext()) {
            root.getChildren().add(new TreeItem<>(it.next()));
        }
        bidderTreeView.setRoot(root);
    }

    public void backButtonClick(ActionEvent actionEvent) throws IOException {
        App.setRoot("homepage");
    }
}
