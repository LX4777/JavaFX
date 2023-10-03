package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class Square extends ShapeWithSize {
    @Override
    public void draw(GraphicsContext graphicsContext, ColorPicker colorPicker) {
        super.draw(graphicsContext, colorPicker);
        graphicsContext.strokeRect(startPoint.x, startPoint.y, width, height);
    }
}
