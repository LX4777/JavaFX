package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class Line extends ShapeWithoutSize{
    public void draw(GraphicsContext graphicsContext, ColorPicker colorPicker) {
        super.draw(graphicsContext, colorPicker);
        graphicsContext.strokeLine(this.point1.x, this.point1.y, this.point2.x, this.point2.y);
    }
}
