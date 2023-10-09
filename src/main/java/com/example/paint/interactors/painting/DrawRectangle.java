package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Rectangle;

public class DrawRectangle extends Draw<Rectangle> {
    javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle();

    public javafx.scene.shape.Rectangle draw(Rectangle shape, Brush brush) {
        rectangle.setWidth(shape.getWidth());
        rectangle.setHeight(shape.getHeight());
        rectangle.setFill(brush.getFillColor());
        rectangle.setStroke(brush.getColor());
        rectangle.setStrokeWidth(brush.getWidth());
        rectangle.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());
        return rectangle;
    }
}
