module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;
    requires com.fasterxml.jackson.databind;


    opens com.example.paint to javafx.fxml;
    exports com.example.paint;
    exports com.example.paint.presentation;
    opens com.example.paint.presentation to javafx.fxml;
    exports com.example.paint.interactors.shapes to com.fasterxml.jackson.databind;
    opens com.example.paint.interactors.shapes to com.fasterxml.jackson.databind;
}