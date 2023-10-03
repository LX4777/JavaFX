package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface IShape {
    void draw(GraphicsContext graphicsContext, Color color, double size);
}
