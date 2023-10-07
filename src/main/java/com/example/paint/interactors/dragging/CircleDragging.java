package com.example.paint.interactors.dragging;

import javafx.scene.shape.Circle;

public class CircleDragging extends ShapeDragging<Circle> {
    @Override
    protected void setX(Circle shape) {
        shape.setCenterX(shape.getCenterX() + offsetX);
    }

    @Override
    protected void setY(Circle shape) {
        shape.setCenterY(shape.getCenterY() + offsetY);
    }

}
