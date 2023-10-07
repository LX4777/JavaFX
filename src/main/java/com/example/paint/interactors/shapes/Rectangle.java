package com.example.paint.interactors.shapes;

import com.example.paint.interactors.dragging.RectangleDragging;
import com.example.paint.interactors.painting.Brush;
import javafx.scene.layout.Pane;

public class Rectangle extends ShapeWithSize {
    @Override
    public void draw(Pane pane, Brush brush) {
        super.draw(pane, brush);
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(this.width, this.height, brush.getFillColor());
        rectangle.setStroke(brush.getColor());
        rectangle.setStrokeWidth(brush.getWidth());
        rectangle.relocate(this.startCoordinate.getX(), this.startCoordinate.getY());
        RectangleDragging rectangleDragging = new RectangleDragging();
        rectangleDragging.setDragAndDrop(rectangle);
        pane.getChildren().add(rectangle);
    }
}
