package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Square;
import javafx.scene.shape.Rectangle;

public class SquareCreator extends ShapeCreator<Square> {
    javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle();

    public Rectangle make(Square shape) {
        shape.setWidth(shape.getHeight());
        rectangle.setWidth(shape.getWidth());
        rectangle.setHeight(shape.getHeight());
        return rectangle;
    }
}
