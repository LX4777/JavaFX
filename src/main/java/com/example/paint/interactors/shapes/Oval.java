package com.example.paint.interactors.shapes;

import com.example.paint.interactors.painting.Brush;
import javafx.scene.layout.Pane;

public class Oval extends ShapeWithSize {
    @Override
    public void draw(Pane pane, Brush brush) {
        super.draw(pane, brush);
        javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse();
        ellipse.setCenterX(this.startCoordinate.getX());
        ellipse.setCenterY(this.startCoordinate.getY());
        ellipse.setRadiusX(this.width / 2);
        ellipse.setRadiusY(this.height / 2);
        ellipse.setFill(brush.getFillColor());
        ellipse.setStroke(brush.getColor());
        ellipse.setStrokeWidth(brush.getWidth());
        ellipse.relocate(this.startCoordinate.getX(), this.startCoordinate.getY());
        pane.getChildren().add(ellipse);
    }
}
