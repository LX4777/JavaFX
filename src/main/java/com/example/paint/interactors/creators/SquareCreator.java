package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Square;
import javafx.scene.shape.Polygon;

public class SquareCreator extends ShapeCreator<Square> {
    Polygon polygon = new Polygon();

    protected static final int POINT_COUNT = 100;

    public Polygon make(Square shape) {
        shape.setWidth(shape.getHeight());

        double width = shape.getWidth();
        double height = shape.getHeight();

        for (int i = 0; i < POINT_COUNT; i++) {
            double ratio = (double) i / POINT_COUNT;
            double x, y;

            if (ratio < 0.25) {
                // Верхняя сторона
                x = ratio * 4 * width;
                y = 0;
            } else if (ratio < 0.5) {
                // Правая сторона
                x = width;
                y = (ratio - 0.25) * 4 * height;
            } else if (ratio < 0.75) {
                // Нижняя сторона
                x = width - (ratio - 0.5) * 4 * width;
                y = height;
            } else {
                // Левая сторона
                x = 0;
                y = height - (ratio - 0.75) * 4 * height;
            }

            polygon.getPoints().addAll(x, y);
        }
        return polygon;
    }
}
