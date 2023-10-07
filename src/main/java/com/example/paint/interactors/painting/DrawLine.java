package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Line;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class DrawLine extends Draw<Line> {
    javafx.scene.shape.Line line = new javafx.scene.shape.Line();
    public Shape draw(Pane pane, Line shape, Brush brush) {
        line.setStartX(shape.getCoordinate1().getX());
        line.setStartY(shape.getCoordinate1().getY());
        line.setEndX(shape.getCoordinate2().getX());
        line.setEndY(shape.getCoordinate2().getY());
        line.setFill(brush.getFillColor());
        line.setStrokeWidth(brush.getWidth());
        line.setStroke(brush.getColor());

        line.relocate(shape.getStartPoint().getX(), shape.getStartPoint().getY());

        pane.getChildren().add(line);
        System.out.println("Log - x1: " + shape.getCoordinate1().getX() + " y1: " + shape.getCoordinate1().getY() + " x2: " + shape.getCoordinate2().getX() + " y2: " + shape.getCoordinate2().getY());
        return line;
    }
}
