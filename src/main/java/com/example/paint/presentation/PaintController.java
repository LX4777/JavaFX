package com.example.paint.presentation;

import com.example.paint.interactors.actions.InitializeShapesSelectAction;
import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.painting.Drawer;
import com.example.paint.interactors.shapes.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class PaintController {
    @FXML
    private Pane pane;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox fill;

    @FXML
    private ChoiceBox<ShapeType> shapesSelect;

    public void initialize() {
        InitializeShapesSelectAction.start(shapesSelect);

        pane.setOnMouseDragged(e -> {
        });

        Drawer drawer = new Drawer();

        this.pane.setOnMousePressed(e -> {
            drawer.setPoint1(new Coordinate(e.getX(), e.getY()));
        });

        this.pane.setOnMouseReleased(e -> {
            drawer.setPoint2(new Coordinate(e.getX(), e.getY()));
            drawer.setBrush(new Brush(colorPicker.getValue(), Double.parseDouble(brushSize.getText()), fill.isSelected()));
            drawer.setPane(pane);

            drawer.draw(shapesSelect.getValue());
        });
    }

    @FXML
    public void onSnapshot() {
//        Snapshot.make(canvas);
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }
}