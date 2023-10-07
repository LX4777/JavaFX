package com.example.paint.interactors.shapes;

import com.example.paint.interactors.painting.Brush;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class Square extends ShapeWithSize {
    @Override
    public Shape draw(Pane pane, Brush brush) {
        this.width = this.height;
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(this.width, this.height, brush.getFillColor());
        rectangle.setStrokeWidth(brush.getWidth());
        rectangle.setStroke(brush.getColor());
        rectangle.relocate(this.startCoordinate.getX(), this.startCoordinate.getY());
        pane.getChildren().add(rectangle);
        return rectangle;
    }
}
