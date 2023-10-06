package com.example.paint.presentation;

import com.example.paint.interactors.actions.InitializeShapesSelectAction;
import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.painting.Drawer;
import com.example.paint.interactors.shapes.*;
import com.example.paint.interactors.tools.Eraser;
import com.example.paint.interactors.tools.Pencil;
import com.example.paint.repository.Snapshot;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;

public class PaintController {
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox eraser;

    @FXML
    private CheckBox pencil;

    @FXML
    private ChoiceBox<ShapeType> shapesSelect;

    public void initialize() {
        InitializeShapesSelectAction.start(shapesSelect);

        canvas.setOnMouseDragged(e -> {
            if (this.eraser.isSelected()) {
                Eraser.start(canvas, e.getX(), e.getY(), Double.parseDouble(brushSize.getText()));
                return;
            }

            if (pencil.isSelected()) {
                Pencil.start(canvas, e.getX(), e.getY(), Double.parseDouble(brushSize.getText()), colorPicker.getValue());
            }
        });

        Drawer drawer = new Drawer();

        this.canvas.setOnMousePressed(e -> {
            drawer.setPoint1(new Coordinate(e.getX(), e.getY()));
        });

        this.canvas.setOnMouseReleased(e -> {
            if (this.eraser.isSelected()) return;

            drawer.setPoint2(new Coordinate(e.getX(), e.getY()));
            drawer.setBrush(new Brush(colorPicker.getValue(), Double.parseDouble(brushSize.getText())));
            drawer.setCanvas(canvas);

            if (!pencil.isSelected()) {
                drawer.draw(shapesSelect.getValue());
            }
        });
    }

    @FXML
    public void onSnapshot() {
        Snapshot.make(canvas);
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }
}