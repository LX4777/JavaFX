package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class Square extends Shape {
    public void draw(GraphicsContext graphicsContext, ColorPicker colorPicker)
    {
        double dx = (x2 > x1) ? x2 - x1 : x1 - x2;
        double dy = (y2 > y1) ? y2 - y1 : y1 - y2;
        graphicsContext.setStroke(colorPicker.getValue());
        graphicsContext.strokeRect(x1, y1, dx, dy);
    }
}
