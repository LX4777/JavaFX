package com.example.paint.interactors.shapes;

import com.example.paint.interactors.painting.Brush;
import javafx.scene.layout.Pane;

public class Line extends ShapeWithoutSize{
    public void draw(Pane pane, Brush brush) {
        javafx.scene.shape.Line line = new javafx.scene.shape.Line();
        line.setStartX(this.coordinate1.getX());
        line.setStartY(this.coordinate1.getY());
        line.setEndX(this.coordinate2.getX());
        line.setEndY(this.coordinate2.getY());
        line.setFill(brush.getFillColor());
        line.setStrokeWidth(brush.getWidth());
        line.setStroke(brush.getColor());

        line.relocate(this.getStartPoint().getX(), this.getStartPoint().getY());

        pane.getChildren().add(line);
        System.out.println("Log - x1: " + this.coordinate1.getX() + " y1: " + this.coordinate1.getY() + " x2: " + this.coordinate2.getX() + " y2: " + this.coordinate2.getY());
    }
}
