package com.example.paint.painting;

import javafx.scene.paint.Color;

public class Brush {
    protected Color color;
    protected double width;

    Brush() {
        this.color = Color.BLACK;
        this.width = 3;
    }

    public Brush(Color color, double width) {
        this.color = color;
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public double getWidth() {
        return width;
    }
}
