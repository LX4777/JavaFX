package com.example.paint.interactors.shapes;

public abstract class Shape implements IDrawable {
    protected Coordinate coordinate1;
    protected Coordinate coordinate2;

    public void setPoints(double x1, double y1, double x2, double y2) {
        setPoint1(x1, y1);
        setPoint2(x2, y2);
    }

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

    private void setPoint1(double x, double y) {
        this.coordinate1 = new Coordinate(x, y);
    }

    private void setPoint2(double x, double y) {
        this.coordinate2 = new Coordinate(x, y);
    }
}
