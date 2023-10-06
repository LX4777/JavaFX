package com.example.paint.interactors.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends ShapeWithoutSize{
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.strokeLine(this.coordinate1.getX(), this.coordinate1.getY(), this.coordinate2.getX(), this.coordinate2.getY());
    }
}
