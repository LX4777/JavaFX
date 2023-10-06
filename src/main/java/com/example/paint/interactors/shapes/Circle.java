package com.example.paint.interactors.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends ShapeWithSize {
    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        this.width = this.height;
        graphicsContext.strokeOval(startCoordinate.getX(), startCoordinate.getY(), width, height);
    }
}