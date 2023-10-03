package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class Square extends Shape {
    public void draw(GraphicsContext graphicsContext, ColorPicker colorPicker) {
        width = (x2 > x1) ? x2 - x1 : x1 - x2;
        height = (y2 > y1) ? y2 - y1 : y1 - y2;

        double x, y;
        if (x2 > x1) {
            if (y2 > y1) {
                x = x1;
                y = y1;
            } else {
                x = x1;
                y = y2;
            }
        } else {
            if (y2 > y1) {
                x = x2;
                y = y1;
            } else {
                x = x2;
                y = y2;
            }
        }

        System.out.println("Log - x1: " + x1 + " y1: " + y1 + " x2: " + x2 + " y2: " + y2 + " w: " + width + " h: " + height);
        graphicsContext.setStroke(colorPicker.getValue());
        graphicsContext.strokeRect(x, y, width, height);
    }
}
