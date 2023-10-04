package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends ShapeWithSize {
    @Override
    public void draw(GraphicsContext graphicsContext, Color color, double size) {
        super.draw(graphicsContext, color, size);
        graphicsContext.strokeOval(startCoordinate.x, startCoordinate.y, width, height);
    }
}
