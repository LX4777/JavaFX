package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Coordinate;
import com.example.paint.interactors.shapes.Star;
import javafx.scene.shape.Polygon;

public class StarCreator extends ShapeCreator<Star> {
    Polygon star = new Polygon();

    public Polygon make(Star shape) {
        shape.setWidth(shape.getHeight());
        Coordinate start = shape.getStartCoordinate();

        star.getPoints().addAll(new Double[]{
                shape.getWidth() / 2 + start.getX(), start.getY(),
                shape.getWidth() / 3 * 2 + start.getX(), shape.getHeight() / 3 + start.getY(),
                shape.getWidth() + start.getX(), shape.getHeight() / 3 + start.getY(),
                shape.getWidth() / 5 * 4 + start.getX(), shape.getHeight() / 2 + start.getY(),
                shape.getWidth() + start.getX(), shape.getHeight() + start.getY(),
                shape.getWidth() / 2 + start.getX(), shape.getHeight() / 3 * 2 + start.getY(),
                start.getX(), shape.getHeight() + start.getY(),
                shape.getWidth() / 5 + start.getX(), shape.getWidth() / 2 + start.getY(),
                start.getX(), shape.getHeight() / 3 + start.getY(),
                shape.getWidth() / 3 + start.getX(), shape.getHeight() / 3 + start.getY()
        });
        return star;
    }
}
