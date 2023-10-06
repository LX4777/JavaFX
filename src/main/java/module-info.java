module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens com.example.paint to javafx.fxml;
    exports com.example.paint;
    exports com.example.paint.presentation;
    opens com.example.paint.presentation to javafx.fxml;
}