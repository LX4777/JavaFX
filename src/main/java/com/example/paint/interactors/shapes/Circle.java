package com.example.paint.interactors.shapes;

import com.example.paint.interactors.dragging.CircleDragging;
import com.example.paint.interactors.painting.Brush;
import javafx.scene.layout.Pane;

public class Circle extends ShapeWithSize {
    @Override
    public void draw(Pane pane, Brush brush) {
        super.draw(pane, brush);
        this.width = this.height;
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(this.width / 2, brush.getFillColor());
        circle.setStroke(brush.getColor());
        circle.setStrokeWidth(brush.getWidth());
        circle.relocate(this.startCoordinate.getX(), this.startCoordinate.getY());
        CircleDragging circleDragging = new CircleDragging();
        circleDragging.setDragAndDrop(circle);
        pane.getChildren().add(circle);
    }
}
