package com.example.paint.interactors.shapes;

import javafx.scene.paint.Color;
import java.util.Objects;

public abstract class Shape {
    protected Coordinate coordinate1;
    protected Coordinate coordinate2;
    protected double strokeWidth;
    protected Color color;
    protected Color fillColor;


    public void setPoints(double x1, double y1, double x2, double y2) {
        setPoint1(x1, y1);
        setPoint2(x2, y2);
    }

    public Coordinate calculateStartPoint() {
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

    private void setPoint1(double x, double y) {
        this.coordinate1 = new Coordinate(x, y);
    }

    private void setPoint2(double x, double y) {
        this.coordinate2 = new Coordinate(x, y);
    }

    public Coordinate getCoordinate1() {
        return coordinate1;
    }

    public Coordinate getCoordinate2() {
        return coordinate2;
    }

    @Override
    public String toString() {
        return "coordinate1=" + coordinate1 + ", coordinate2=" + coordinate2 + ", strokeWidth=" + strokeWidth + ", color=" + color + ", fillColor=" + fillColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(coordinate1, shape.coordinate1) && Objects.equals(coordinate2, shape.coordinate2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate1, coordinate2);
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public Color getColor() {
        return color;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getFillColor() {
        return fillColor;
    }
}
