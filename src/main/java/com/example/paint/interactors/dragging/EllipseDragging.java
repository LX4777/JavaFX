package com.example.paint.interactors.dragging;

import javafx.scene.shape.Ellipse;

public class EllipseDragging extends ShapeDragging<Ellipse> {
    @Override
    protected void setX(Ellipse shape) {
        shape.setCenterX(shape.getCenterX() + offsetX);
    }

    @Override
    protected void setY(Ellipse shape) {
        shape.setCenterY(shape.getCenterY() + offsetY);
    }

}
