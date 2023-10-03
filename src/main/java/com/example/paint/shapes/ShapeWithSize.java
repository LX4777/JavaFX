package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public abstract class ShapeWithSize extends Shape {
    protected Point startPoint;
    protected double width;
    protected double height;

    protected Point getStartPoint() {
        double x, y;
        if (this.point2.x > this.point1.x) {
            if (this.point2.y > this.point1.y) {
                x = this.point1.x;
                y = this.point1.y;
            } else {
                x = this.point1.x;
                y = this.point2.y;
            }
        } else {
            if (this.point2.y > this.point1.y) {
                x = this.point2.x;
                y = this.point1.y;
            } else {
                x = this.point2.x;
                y = this.point2.y;
            }
        }
        return new Point(x, y);
    }

    public void draw(GraphicsContext graphicsContext, ColorPicker colorPicker) {
        this.width = (this.point2.x > this.point1.x) ? this.point2.x - this.point1.x : this.point1.x - this.point2.x;
        this.height = (this.point2.y > this.point1.y) ? this.point2.y - this.point1.y : this.point1.y - this.point2.y;

        this.startPoint = this.getStartPoint();

        System.out.println("Log - x1: " + this.point1.x + " y1: " + this.point1.y + " x2: " + this.point2.x + " y2: " + this.point2.y + " w: " + this.width + " h: " + this.height);
        graphicsContext.setStroke(colorPicker.getValue());
    }
}
