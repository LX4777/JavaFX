package com.example.paint.painting;

import com.example.paint.shapes.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Drawer {
    protected Brush brush;
    protected Canvas canvas;

    public Drawer() {
        this.brush = new Brush();
        this.canvas = new Canvas();
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void draw(Shape shape) {
        GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(this.brush.getWidth());
        graphicsContext.setStroke(this.brush.getColor());
        shape.draw(graphicsContext, this.brush.getColor(), brush.getWidth());
    }
}
