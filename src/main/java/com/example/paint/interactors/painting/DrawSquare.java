package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Square;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class DrawSquare extends Draw<Square> {
    public Shape draw(Pane pane, Square shape, Brush brush) {
        shape.setWidth(shape.getHeight());
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(shape.getWidth(), shape.getHeight(), brush.getFillColor());
        rectangle.setStrokeWidth(brush.getWidth());
        rectangle.setStroke(brush.getColor());
        rectangle.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());
        pane.getChildren().add(rectangle);
        return rectangle;
    }
}
