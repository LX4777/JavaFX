package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Line;
import javafx.scene.shape.Polygon;

public class LineCreator extends ShapeCreator<Line> {
    Polygon polygon = new Polygon();

    protected static final int POINT_COUNT = 100;

    public Polygon make(Line shape) {
        double startX = shape.getCoordinate1().getX();
        double startY = shape.getCoordinate1().getY();
        double endX = shape.getCoordinate2().getX();
        double endY = shape.getCoordinate2().getY();

        for (int i = 0; i <= POINT_COUNT; i++) {
            double x = startX + (endX - startX) * i / POINT_COUNT;
            double y = startY + (endY - startY) * i / POINT_COUNT;
            polygon.getPoints().addAll(x, y);
        }
        return polygon;
    }
}
