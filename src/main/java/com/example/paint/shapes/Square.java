package com.example.paint.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;

public class Square extends Shape {
    private void countWidth() {
        width = (this.point2.x > this.point1.x) ? this.point2.x - this.point1.x : this.point1.x - this.point2.x;
    }

    private void countHeight() {
        height = (this.point2.y > this.point1.y) ? this.point2.y - this.point1.y : this.point1.y - this.point2.y;
    }

    private Point getStartPoint() {
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
        countWidth();
        countHeight();
        Point startPoint = this.getStartPoint();

        System.out.println("Log - x1: " + this.point1.x + " y1: " + this.point1.y + " x2: " + this.point2.x + " y2: " + this.point2.y + " w: " + width + " h: " + height);
        graphicsContext.setStroke(colorPicker.getValue());
        graphicsContext.strokeRect(startPoint.x, startPoint.y, width, height);
    }
}
