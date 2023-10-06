package com.example.paint.interactors.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends ShapeWithSize {
    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        graphicsContext.strokeRect(startCoordinate.getX(), startCoordinate.getY(), width, height);
    }
}
