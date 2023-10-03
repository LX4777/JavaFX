package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public abstract class Shape implements IShape {
    protected double x1;
    protected double y1;
    protected double x2;
    protected double y2;

    public void setPoints(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public void setPoint1(double x, double y) {
        this.x1 = x;
        this.y1 = y;
    }
    public void setPoints2(double x, double y) {
        this.x2 = x;
        this.y2 = y;
    }

    public abstract void draw(GraphicsContext graphicsContext, ColorPicker colorPicker);
}
