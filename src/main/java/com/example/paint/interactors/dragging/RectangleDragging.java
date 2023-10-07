package com.example.paint.interactors.dragging;

import javafx.scene.shape.Rectangle;

public class RectangleDragging extends ShapeDragging<Rectangle> {
    @Override
    protected void setX(Rectangle shape) {
        shape.setX(shape.getX() + offsetX);
    }

    @Override
    protected void setY(Rectangle shape) {
        shape.setY(shape.getY() + offsetY);
    }
}
