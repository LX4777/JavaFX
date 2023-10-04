package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements IShape {
    protected Coordinate coordinate1;
    protected Coordinate coordinate2;

    public void setPoints(double x1, double y1, double x2, double y2) {
        setPoint1(x1, y1);
        setPoints2(x2, y2);
    }

    public void setPoint1(double x, double y) {
        this.coordinate1 = new Coordinate(x, y);
    }

    public void setPoints2(double x, double y) {
        this.coordinate2 = new Coordinate(x, y);
    }

    public  void draw(GraphicsContext graphicsContext, Color color, double size) {
        graphicsContext.setLineWidth(size);
        graphicsContext.setStroke(color);
    };
}
