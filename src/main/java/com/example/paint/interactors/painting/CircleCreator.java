package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Circle;

public class CircleCreator extends ShapeCreator<Circle> {
    javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle();

    public javafx.scene.shape.Circle make(com.example.paint.interactors.shapes.Circle shape, Brush brush) {
        shape.setWidth(shape.getHeight());
        circle.setRadius(shape.getWidth() / 2);
        circle.setFill(brush.getFillColor());
        circle.setStroke(brush.getColor());
        circle.setStrokeWidth(brush.getWidth());
        circle.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());
        return circle;
    }
}
