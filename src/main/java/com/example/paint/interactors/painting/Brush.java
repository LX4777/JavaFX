package com.example.paint.interactors.painting;

import javafx.scene.paint.Color;

public class Brush {
    protected Color color;
    protected double width;
    protected boolean fill;

    Brush() {
        this.color = Color.BLACK;
        this.width = 3;
        this.fill = false;
    }

    public Brush(Color color, double width, boolean fill) {
        this.color = color;
        this.width = width;
        this.fill = fill;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public Color getColor() {
        return color;
    }

    public double getWidth() {
        return width;
    }

    public boolean isFill() {
        return this.fill;
    }

    public Color getFillColor() {
        return this.isFill() ? this.color : new Color(0, 0, 0, 0);
    }
}
