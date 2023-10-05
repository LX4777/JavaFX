package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends ShapeWithoutSize{
    public void draw(GraphicsContext graphicsContext, Color color, double size) {
        super.draw(graphicsContext, color, size);
        graphicsContext.strokeLine(this.coordinate1.getX(), this.coordinate1.getY(), this.coordinate2.getX(), this.coordinate2.getY());
    }
}
