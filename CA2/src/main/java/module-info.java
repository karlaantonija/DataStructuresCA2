module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.controllers;
    opens org.controllers to javafx.fxml;

}