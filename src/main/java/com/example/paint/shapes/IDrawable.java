package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface IDrawable {
    void draw(GraphicsContext graphicsContext, Color color, double size);
}
