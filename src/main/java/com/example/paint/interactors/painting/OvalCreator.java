package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.Oval;
import javafx.scene.shape.Ellipse;

public class OvalCreator extends ShapeCreator<Oval> {
    javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse();

    @Override
    public Ellipse make(Oval shape, Brush brush) {
        ellipse.setCenterX(shape.getStartCoordinate().getX());
        ellipse.setCenterY(shape.getStartCoordinate().getY());
        ellipse.setRadiusX(shape.getWidth() / 2);
        ellipse.setRadiusY(shape.getHeight() / 2);
        ellipse.setFill(brush.getFillColor());
        ellipse.setStroke(brush.getColor());
        ellipse.setStrokeWidth(brush.getWidth());
        ellipse.relocate(shape.getStartCoordinate().getX(), shape.getStartCoordinate().getY());

        return ellipse;
    }
}
