package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Line;

public class LineCreator extends ShapeCreator<Line> {
    javafx.scene.shape.Line line = new javafx.scene.shape.Line();

    public javafx.scene.shape.Line make(Line shape) {
        line.setStartX(shape.getCoordinate1().getX());
        line.setStartY(shape.getCoordinate1().getY());
        line.setEndX(shape.getCoordinate2().getX());
        line.setEndY(shape.getCoordinate2().getY());

        line.relocate(shape.getStartPoint().getX(), shape.getStartPoint().getY());

        System.out.println("Log - x1: " + shape.getCoordinate1().getX() + " y1: " + shape.getCoordinate1().getY() + " x2: " + shape.getCoordinate2().getX() + " y2: " + shape.getCoordinate2().getY());
        return line;
    }
}
