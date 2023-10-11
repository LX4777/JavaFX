package com.example.paint.repository;

import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.painting.Drawer;
import com.example.paint.interactors.shapes.*;
import com.example.paint.interactors.states.EditorStateSingleton;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;

public class ShapesRestorer {
    public static void restoreFromStore(Pane pane) {
        EditorStateSingleton editorStateSingleton = EditorStateSingleton.getInstance();
        HashMap<String, ArrayList<Shape>> shapes = editorStateSingleton.getCreatedShapes();

        restore(pane, shapes);
    }

    public static void restore(Pane pane, HashMap<String, ArrayList<Shape>> shapes) {
        pane.getChildren().clear();

        shapes.forEach((key, shapeList) -> {
            ShapeType type = ShapeType.getByLatinName(key);
            if (type != null) restoreShape(shapeList, pane, type);
        });
    }

    private static void restoreShape(ArrayList<Shape> shapeList, Pane pane, ShapeType type) {
        shapeList.forEach(shape -> {
            Drawer drawer = new Drawer();
            drawer.setPoint1(shape.getCoordinate1());
            drawer.setPoint2(shape.getCoordinate2());
            drawer.setBrush(new Brush(shape.getColor(), shape.getStrokeWidth(), shape.getColor().equals(shape.getFillColor())));
            drawer.setPane(pane);
            drawer.draw(type);
        });
    }
}
