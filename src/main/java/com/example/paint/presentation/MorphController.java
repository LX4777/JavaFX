package com.example.paint.presentation;

import com.example.paint.interactors.actions.InitializeShapesSelectAction;
import com.example.paint.interactors.morphing.MorphTo;
import com.example.paint.interactors.morphing.MorphToFactory;
import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.painting.Drawer;
import com.example.paint.interactors.shapes.Coordinate;
import com.example.paint.interactors.shapes.ShapeType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class MorphController {
    @FXML
    private Pane pane;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private ChoiceBox<ShapeType> shapesSelect;

    @FXML
    private ChoiceBox<ShapeType> morphShapesSelect;

    @FXML
    private Button startMorphButton;

    public void initialize() {
        InitializeShapesSelectAction.start(shapesSelect);
        InitializeShapesSelectAction.start(morphShapesSelect);

        startMorphButton.setOnAction(e -> {
            pane.getChildren().removeAll(pane.getChildren());

            Drawer drawer = new Drawer();
            drawer.setPoint1(new Coordinate(pane.getWidth() / 2 - 100, pane.getHeight() / 2 - 100));
            drawer.setPoint2(new Coordinate(pane.getWidth() / 2 + 100, pane.getHeight() / 2 + 200));
            drawer.setBrush(new Brush(colorPicker.getValue(), 3, true));
            drawer.setPane(pane);
            Shape newShape = drawer.draw(shapesSelect.getValue());
            MorphTo morphTo = MorphToFactory.createMorph(morphShapesSelect.getValue());
            morphTo.morph(newShape);
        });
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }
}