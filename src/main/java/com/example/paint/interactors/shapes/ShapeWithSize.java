package com.example.paint.interactors.shapes;

import java.util.Objects;

public abstract class ShapeWithSize extends Shape {
    protected Coordinate startCoordinate;
    protected double width;
    protected double height;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    private void calculatePoint() {
        this.width = (this.coordinate2.getX() > this.coordinate1.getX()) ? this.coordinate2.getX() - this.coordinate1.getX() : this.coordinate1.getX() - this.coordinate2.getX();
        this.height = (this.coordinate2.getY() > this.coordinate1.getY()) ? this.coordinate2.getY() - this.coordinate1.getY() : this.coordinate1.getY() - this.coordinate2.getY();
        this.startCoordinate = this.calculateStartPoint();
        System.out.println("Log - x1: " + this.coordinate1.getX() + " y1: " + this.coordinate1.getY() + " x2: " + this.coordinate2.getX() + " y2: " + this.coordinate2.getY() + " w: " + this.width + " h: " + this.height);
    }

    @Override
    public void setPoints(double x1, double y1, double x2, double y2) {
        super.setPoints(x1, y1, x2, y2);
        this.calculatePoint();
    }

    @Override
    public String toString() {
        return super.toString() + ", width=" + this.width + ", height=" + this.height + ", startCoordinate=" + this.startCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShapeWithSize that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(width, that.width) == 0 && Double.compare(height, that.height) == 0 && Objects.equals(startCoordinate, that.startCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), startCoordinate, width, height);
    }
}
