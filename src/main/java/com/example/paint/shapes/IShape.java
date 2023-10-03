package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public interface IShape {
    void draw(GraphicsContext graphicsContext, ColorPicker colorPicker);
}
