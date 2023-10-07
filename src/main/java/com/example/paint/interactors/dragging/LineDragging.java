package com.example.paint.interactors.dragging;

import javafx.scene.shape.Line;

public class LineDragging extends ShapeDragging<Line> {
    @Override
    protected void setX(Line shape) {
        shape.setStartX(shape.getStartX() + offsetX);
        shape.setEndX(shape.getEndX() + offsetX);
    }

    @Override
    protected void setY(Line shape) {
        shape.setStartY(shape.getStartY() + offsetY);
        shape.setEndY(shape.getEndY() + offsetY);
    }
}
