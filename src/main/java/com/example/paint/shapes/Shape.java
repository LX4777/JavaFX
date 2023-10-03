package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public abstract class Shape implements IShape {
    protected Point point1;
    protected Point point2;
    protected double width;
    protected double height;

    public void setPoints(double x1, double y1, double x2, double y2) {
        setPoint1(x1, y1);
        setPoints2(x2, y2);
    }

    public void setPoint1(double x, double y) {
        this.point1 = new Point(x, y);
    }

    public void setPoints2(double x, double y) {
        this.point2 = new Point(x, y);
    }

    public abstract void draw(GraphicsContext graphicsContext, ColorPicker colorPicker);
}
