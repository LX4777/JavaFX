package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends ShapeWithoutSize{
    public void draw(GraphicsContext graphicsContext, Color color, double size) {
        super.draw(graphicsContext, color, size);
        graphicsContext.strokeLine(this.coordinate1.x, this.coordinate1.y, this.coordinate2.x, this.coordinate2.y);
    }
}
