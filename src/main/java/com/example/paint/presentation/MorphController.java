package com.example.paint.presentation;

import com.example.paint.interactors.actions.InitializeShapesSelectAction;
import com.example.paint.interactors.morphing.Morph;
import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.painting.Drawer;
import com.example.paint.interactors.shapes.Coordinate;
import com.example.paint.interactors.shapes.ShapeType;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class MorphController {
    @FXML
    private Pane pane;

    @FXML
    private ChoiceBox<ShapeType> shapesSelect;

    @FXML
    private ChoiceBox<ShapeType> morphShapesSelect;

    @FXML
    private Button startMorphButton;

    @FXML
    private Slider step;

    public void initialize() {
        InitializeShapesSelectAction.run(shapesSelect);
        InitializeShapesSelectAction.run(morphShapesSelect);

        startMorphButton.setOnAction(e -> {
            step.setValue(0);
            pane.getChildren().removeAll(pane.getChildren());

            Drawer drawer = new Drawer();
            drawer.setPoint1(new Coordinate(pane.getWidth() / 2 - 100, pane.getHeight() / 2 - 100));
            drawer.setPoint2(new Coordinate(pane.getWidth() / 2 + 200, pane.getHeight() / 2 + 300));
            drawer.setBrush(new Brush(Color.BLACK, 3, true));
            drawer.setPane(pane);
            Shape newShape = drawer.draw(shapesSelect.getValue());

            Drawer drawer2 = new Drawer();
            drawer2.setPoint1(new Coordinate(pane.getWidth() / 2 + 100, pane.getHeight() / 2 + 100));
            drawer2.setPoint2(new Coordinate(pane.getWidth() / 2 + 300, pane.getHeight() / 2 + 500));
            drawer2.setBrush(new Brush(Color.BLACK, 3, true));
            drawer2.setPane(pane);
            Shape newShape2 = drawer2.draw(morphShapesSelect.getValue());

            pane.getChildren().clear();
            Morph toMorph = new Morph();

            step.setOnMouseDragged(event -> {
                pane.getChildren().clear();
//                newMorph.make(pane, (Polygon) newShape, (Polygon) newShape2, 0);
                toMorph.make(pane, (Polygon) newShape, (Polygon) newShape2, (int) step.getValue());
//                newMorph.make(pane, (Polygon) newShape, (Polygon) newShape2, 99);
            });
        });
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }
}