package com.example.paint.interactors.actions;

import com.example.paint.interactors.shapes.ShapeType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

public class InitializeShapesSelectAction {
    public static void run(ChoiceBox<ShapeType> shapesSelect)
    {
        ObservableList<ShapeType> figures = FXCollections.observableArrayList(ShapeType.values());

        shapesSelect.setConverter(ShapeType.converter());
        shapesSelect.setItems(figures);
        shapesSelect.setValue(figures.get(0));
        shapesSelect.setTooltip(new Tooltip("Выберите фигуру"));
    }
}
