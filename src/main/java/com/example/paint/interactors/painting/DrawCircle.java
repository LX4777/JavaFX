package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class DrawCircle extends Draw<Circle> {
    javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle();
    public Shape draw(Pane pane, com.example.paint.interactors.shapes.Circle shape, Brush brush) {
        shape.setWidth(shape.getHeight());
        circle.setRadius(shape.getWidth() / 2);
        circle.setFill(brush.getFillColor());
        circle.setStroke(brush.getColor());
        circle.setStrokeWidth(brush.getWidth());
        circle.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());
        pane.getChildren().add(circle);
        return circle;
    }
}