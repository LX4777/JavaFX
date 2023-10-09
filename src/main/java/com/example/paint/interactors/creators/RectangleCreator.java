package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Rectangle;

public class RectangleCreator extends ShapeCreator<Rectangle> {
    javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle();

    public javafx.scene.shape.Rectangle make(Rectangle shape) {
        rectangle.setWidth(shape.getWidth());
        rectangle.setHeight(shape.getHeight());
        rectangle.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());
        return rectangle;
    }
}
