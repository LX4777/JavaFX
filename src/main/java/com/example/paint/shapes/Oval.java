package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class Oval extends ShapeWithSize {
    @Override
    public void draw(GraphicsContext graphicsContext, ColorPicker colorPicker) {
        super.draw(graphicsContext, colorPicker);
        graphicsContext.strokeOval(startPoint.x, startPoint.y, width, height);
    }
}
