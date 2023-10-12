package com.example.paint.interactors.dragging;

import javafx.scene.shape.Polygon;

public class PolygonDragging extends ShapeDragging<Polygon> {
    @Override
    protected void setX(Polygon shape) {
        for (int i = 0; i < shape.getPoints().size(); i = i + 2) {
            shape.getPoints().set(i, shape.getPoints().get(i) + offsetX);
        }
    }

    @Override
    protected void setY(Polygon shape) {
        for (int i = 1; i < shape.getPoints().size(); i = i + 2) {
            shape.getPoints().set(i, shape.getPoints().get(i) + offsetY);
        }
    }
}
