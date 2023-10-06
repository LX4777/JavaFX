package com.example.paint.interactors.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class ShapeWithSize extends Shape {
    protected Coordinate startCoordinate;
    protected double width;
    protected double height;

    protected Coordinate getStartPoint() {
        double x, y;
        if (this.coordinate2.getX() > this.coordinate1.getX()) {
            if (this.coordinate2.getY() > this.coordinate1.getY()) {
                x = this.coordinate1.getX();
                y = this.coordinate1.getY();
            } else {
                x = this.coordinate1.getX();
                y = this.coordinate2.getY();
            }
        } else {
            if (this.coordinate2.getY() > this.coordinate1.getY()) {
                x = this.coordinate2.getX();
                y = this.coordinate1.getY();
            } else {
                x = this.coordinate2.getX();
                y = this.coordinate2.getY();
            }
        }
        return new Coordinate(x, y);
    }

    public void draw(GraphicsContext graphicsContext) {
        this.width = (this.coordinate2.getX() > this.coordinate1.getX()) ? this.coordinate2.getX() - this.coordinate1.getX() : this.coordinate1.getX() - this.coordinate2.getX();
        this.height = (this.coordinate2.getY() > this.coordinate1.getY()) ? this.coordinate2.getY() - this.coordinate1.getY() : this.coordinate1.getY() - this.coordinate2.getY();
        this.startCoordinate = this.getStartPoint();

        System.out.println("Log - x1: " + this.coordinate1.getX() + " y1: " + this.coordinate1.getY() + " x2: " + this.coordinate2.getX() + " y2: " + this.coordinate2.getY() + " w: " + this.width + " h: " + this.height);
    }
}
