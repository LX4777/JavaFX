package com.example.paint.presentation;

import com.example.paint.interactors.actions.InitializeShapesSelectAction;
import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.painting.Drawer;
import com.example.paint.interactors.shapes.Coordinate;
import com.example.paint.interactors.shapes.ShapeType;
import com.example.paint.interactors.states.EditorStateSingleton;
import com.example.paint.interactors.states.StateType;
import com.example.paint.repository.JsonParser;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

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
    private CheckBox drag;

    @FXML
    private ChoiceBox<ShapeType> shapesSelect;
    final EditorStateSingleton editorState = EditorStateSingleton.getInstance();

    public void initialize() {
        InitializeShapesSelectAction.start(shapesSelect);

        Drawer drawer = new Drawer();

        drag.setOnMouseClicked(e -> {
            editorState.setStateType(drag.isSelected() ? StateType.DRAG_AND_DROP : StateType.DRAWING);
        });

        this.pane.setOnMousePressed(e -> {
            drawer.setPoint1(new Coordinate(e.getX(), e.getY()));
        });

        this.pane.setOnMouseReleased(e -> {
            drawer.setPoint2(new Coordinate(e.getX(), e.getY()));
            drawer.setBrush(new Brush(colorPicker.getValue(), Double.parseDouble(brushSize.getText()), fill.isSelected()));
            drawer.setPane(pane);

            if (!drag.isSelected()) {
                drawer.draw(shapesSelect.getValue());
            }
        });
    }

    @FXML
    public void onSave() throws IOException {
        JsonParser.save();
    }

    @FXML
    public void onLoad() throws IOException {
        JsonParser.load();
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }
}