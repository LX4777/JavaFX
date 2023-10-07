package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Oval;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class DrawOval extends Draw<Oval> {
    public Shape draw(Pane pane, Oval shape, Brush brush) {
        javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse();
        ellipse.setCenterX(shape.getStartCoordinate().getX());
        ellipse.setCenterY(shape.getStartCoordinate().getY());
        ellipse.setRadiusX(shape.getWidth() / 2);
        ellipse.setRadiusY(shape.getHeight() / 2);
        ellipse.setFill(brush.getFillColor());
        ellipse.setStroke(brush.getColor());
        ellipse.setStrokeWidth(brush.getWidth());
        ellipse.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());

        pane.getChildren().add(ellipse);
        return ellipse;
    }
}
