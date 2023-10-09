package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Square;
import javafx.scene.shape.Rectangle;

public class DrawSquare extends Draw<Square> {
    javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle();

    public Rectangle draw(Square shape, Brush brush) {
        shape.setWidth(shape.getHeight());
        rectangle.setWidth(shape.getWidth());
        rectangle.setHeight(shape.getHeight());
        rectangle.setFill(brush.getFillColor());
        rectangle.setStrokeWidth(brush.getWidth());
        rectangle.setStroke(brush.getColor());
        rectangle.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());
        return rectangle;
    }
}
