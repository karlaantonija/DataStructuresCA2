package org.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.App;
import org.models.AuctionLot;
import org.models.Bid;
import org.utils.MyIterator;

import java.io.IOException;

public class AuctionLotController {

    //AUCTION LOT VARIABLES
    public Button ALdeleteButton;
    public TextField ALtitleField;
    public TextField ALdescriptionField;
    public ComboBox<String> ALtypeBox;
    public DatePicker ALoriginDate;
    public TextField ALaskingPriceField;
    public TextField ALimageField;
    public Button ALaddButton;
    public TextArea detailsArea;
    public VBox ALVboxForm;
    public VBox bidVboxForm;
    public TreeView<Object> ALtreeView;

    //ADDING METHODS
    public void addAuctionLot(ActionEvent event) {

        double askingPrice;
        try {
            askingPrice = Double.parseDouble(ALaskingPriceField.getText().trim());
        } catch (NumberFormatException e) {
            System.out.println("Asking price must be a number");
            return;
        }

        AuctionLot auctionLot = new AuctionLot(
                ALtitleField.getText(), ALdescriptionField.getText(),
                ALtypeBox.getValue(), ALoriginDate.getValue(),
                askingPrice, ALimageField.getText());
        App.auctionLotSystemAPI.addAuctionLot(auctionLot);
        refreshTree();
    }

    //SELECTING
    public void selectItem() {
        TreeItem<Object> item = ALtreeView.getSelectionModel().getSelectedItem();

        if (item != null) {
            System.out.println(item.getValue());
        }

        Object obj = item.getValue();
        if (obj instanceof AuctionLot) {

            ALVboxForm.setVisible(false);

            bidVboxForm.setVisible(true);

            AuctionLot a = (AuctionLot) obj;

            detailsArea.setText(
                    "Title: " + a.getTitle() +
                            "\nDescription: " + a.getDescription() +
                            "\nOrigin Date: " + a.getDateOfOrigin() +
                            "\nAsking Price: " + a.getAskingPrice() +
                            "\nImage: " + a.getImage()
            );

            //so that clicking a white space in the treeView does not give an error
            if (item == null) return;
        }



        else if(obj instanceof Bid) {

            ALVboxForm.setVisible(false);

            bidVboxForm.setVisible(false);

            Bid bid = (Bid) obj;

            detailsArea.setText(
                    "Amount: " + bid.getAmount()
            );
            }



    }

    //REMOVING METHODS

    //Kianna
    public void removeAuctionLot(MouseEvent event) {

    }


    @FXML
    public void initialize() {

        if (bidVboxForm != null) {
            bidVboxForm.setVisible(false);
        }

        //for Plot type combobox
        if (ALtypeBox != null) {
            ALtypeBox.getItems().addAll("Porcelain", "Furniture", "Tech");
        }


        //for TreeView. If statement is necessary because this controller is used by homepage.fxml too, and it doesn't have a treeView.
        //It allows the user to select a campsite they added, so that they can add an auction lot to it.
        if (ALtreeView != null) {
            TreeItem<Object> rootItem = new TreeItem<>("Auction Lots");
            rootItem.setExpanded(true);


            ALtreeView.setRoot(rootItem);

            ALtreeView.getSelectionModel()
                    .selectedItemProperty()
                    .addListener((obs, oldItem, newItem) -> {

                        if (newItem != null) {
                            System.out.println("Selected: "
                                    + newItem.getValue());
                        }
                    });

        }
    }


    private void refreshTree() {
        if (ALtreeView == null) return;

        TreeItem<Object> root = new TreeItem<>("Auction Lots");
        root.setExpanded(true);

        MyIterator<AuctionLot> it = App.auctionLotSystemAPI.getAuctionLots().iterator();
        while (it.hasNext()) {
            root.getChildren().add(new TreeItem<>(it.next()));
        }
        ALtreeView.setRoot(root);
    }
}
