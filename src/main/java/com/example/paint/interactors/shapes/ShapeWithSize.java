package com.example.paint.interactors.shapes;

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
        return "coordinate1.X: " + this.coordinate1.getX()
                + " coordinate1.Y: " + this.coordinate1.getY()
                + " coordinate2.X: " + this.coordinate2.getX()
                + " coordinate2.Y: " + this.coordinate2.getY()
                + " width: " + this.width
                + " height: " + this.height;
    }
}
