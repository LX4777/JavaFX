package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends ShapeWithSize {
    @Override
    public void draw(GraphicsContext graphicsContext, Color color, double size) {
        super.draw(graphicsContext, color, size);
        graphicsContext.strokeOval(startPoint.x, startPoint.y, width, height);
    }
}
