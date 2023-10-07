package com.example.paint.interactors.shapes;

public abstract class ShapeWithSize extends Shape {
    protected Coordinate startCoordinate;
    protected double width;
    protected double height;

    private void calculatePoint() {
        this.width = (this.coordinate2.getX() > this.coordinate1.getX()) ? this.coordinate2.getX() - this.coordinate1.getX() : this.coordinate1.getX() - this.coordinate2.getX();
        this.height = (this.coordinate2.getY() > this.coordinate1.getY()) ? this.coordinate2.getY() - this.coordinate1.getY() : this.coordinate1.getY() - this.coordinate2.getY();
        this.startCoordinate = this.getStartPoint();
        System.out.println("Log - x1: " + this.coordinate1.getX() + " y1: " + this.coordinate1.getY() + " x2: " + this.coordinate2.getX() + " y2: " + this.coordinate2.getY() + " w: " + this.width + " h: " + this.height);
    }

    @Override
    public void setPoints(double x1, double y1, double x2, double y2) {
        super.setPoints(x1, y1, x2, y2);
        this.calculatePoint();
    }
}
