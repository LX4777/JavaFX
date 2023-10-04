package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class ShapeWithSize extends Shape {
    protected Coordinate startCoordinate;
    protected double width;
    protected double height;

    protected Coordinate getStartPoint() {
        double x, y;
        if (this.coordinate2.x > this.coordinate1.x) {
            if (this.coordinate2.y > this.coordinate1.y) {
                x = this.coordinate1.x;
                y = this.coordinate1.y;
            } else {
                x = this.coordinate1.x;
                y = this.coordinate2.y;
            }
        } else {
            if (this.coordinate2.y > this.coordinate1.y) {
                x = this.coordinate2.x;
                y = this.coordinate1.y;
            } else {
                x = this.coordinate2.x;
                y = this.coordinate2.y;
            }
        }
        return new Coordinate(x, y);
    }

    public void draw(GraphicsContext graphicsContext, Color color, double size) {
        super.draw(graphicsContext, color, size);
        this.width = (this.coordinate2.x > this.coordinate1.x) ? this.coordinate2.x - this.coordinate1.x : this.coordinate1.x - this.coordinate2.x;
        this.height = (this.coordinate2.y > this.coordinate1.y) ? this.coordinate2.y - this.coordinate1.y : this.coordinate1.y - this.coordinate2.y;
        this.startCoordinate = this.getStartPoint();

        System.out.println("Log - x1: " + this.coordinate1.x + " y1: " + this.coordinate1.y + " x2: " + this.coordinate2.x + " y2: " + this.coordinate2.y + " w: " + this.width + " h: " + this.height);
    }
}
