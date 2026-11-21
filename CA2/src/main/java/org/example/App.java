package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controllers.AuctionLotSystemAPI;
import org.models.AuctionLot;

import java.io.IOException;
import java.time.LocalDate;

/**
 * JavaFX App
 */
public class App extends Application {

    public static AuctionLotSystemAPI auctionLotSystemAPI = new AuctionLotSystemAPI();

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        sampleTests(); //TODO remove at some point

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("homepage.fxml"));
        Pane p = fxmlLoader.load();
        scene = new Scene(p, 720, 620);

        stage.setScene(scene);
        stage.show();
    }

    private static void sampleTests() {

        auctionLotSystemAPI.addAuctionLot(
                new AuctionLot("Karla's Couch", "Hard surface blue couch", "Furniture",
                        LocalDate.of(2006,6,25), 150, "url link")
        );

        auctionLotSystemAPI.addAuctionLot(
                new AuctionLot("Karla's Vase", "flower/animal designs", "Porcelain" ,LocalDate.of(2007,10,6), 10, "url link")
        );

        auctionLotSystemAPI.addAuctionLot(
                new AuctionLot("Karla's Painting", "plantsss", "art", LocalDate.of(1965,6,30), 150, "url link")
        );
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}