package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Oval;
import javafx.scene.shape.Polygon;

public class OvalCreator extends ShapeCreator<Oval> {
    Polygon polygon = new Polygon();

    protected static final int POINT_COUNT = 100;

    public Polygon make(com.example.paint.interactors.shapes.Oval shape) {
        double circleCenterX = (shape.getStartCoordinate().getX() + shape.getWidth()) / 2;
        double circleCenterY = (shape.getStartCoordinate().getY() + shape.getHeight()) / 2;
        double circleSideX = shape.getWidth() / 2;
        double circleSideY = shape.getHeight() / 2;

        addPoints(circleCenterX, circleCenterY, circleSideX, circleSideY);

        return polygon;
    }

    protected void addPoints(double centerX, double centerY, double sideX, double sideY) {
        for (int i = 0; i < POINT_COUNT; i++) {
            double x = centerX
                    + Math.cos(Math.toRadians((double) (i * 360) / POINT_COUNT))
                    * sideX;
            double y = centerY
                    + Math.sin(Math.toRadians((double) (i * 360) / POINT_COUNT))
                    * sideY;

            polygon.getPoints().addAll(x, y);
        }
    }
}
