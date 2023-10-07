package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class DrawRectangle extends Draw<Rectangle> {
    public Shape draw(Pane pane, Rectangle shape, Brush brush) {
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(shape.getWidth(), shape.getHeight(), brush.getFillColor());
        rectangle.setStroke(brush.getColor());
        rectangle.setStrokeWidth(brush.getWidth());
        rectangle.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());
        pane.getChildren().add(rectangle);
        return rectangle;
    }
}
