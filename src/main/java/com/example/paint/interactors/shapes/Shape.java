package com.example.paint.interactors.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape implements IDrawable {
    protected Coordinate coordinate1;
    protected Coordinate coordinate2;

    public void setPoints(double x1, double y1, double x2, double y2) {
        setPoint1(x1, y1);
        setPoint2(x2, y2);
    }

    public void setPoint1(double x, double y) {
        this.coordinate1 = new Coordinate(x, y);
    }

    public void setPoint2(double x, double y) {
        this.coordinate2 = new Coordinate(x, y);
    }

    public abstract void draw(GraphicsContext graphicsContext);
}