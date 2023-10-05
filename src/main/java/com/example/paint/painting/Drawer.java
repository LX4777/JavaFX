package com.example.paint.painting;

import com.example.paint.shapes.Coordinate;
import com.example.paint.shapes.Shape;
import com.example.paint.shapes.ShapeFactory;
import com.example.paint.shapes.ShapeType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Drawer {
    protected Brush brush;
    protected Canvas canvas;
    protected ShapeFactory shapeFactory;

    protected Coordinate point1;
    protected Coordinate point2;

    public Drawer() {
        this.brush = new Brush();
        this.canvas = new Canvas();
        this.shapeFactory = new ShapeFactory();
    }

    public void setPoint1(Coordinate point1) {
        this.point1 = point1;
    }

    public void setPoint2(Coordinate point2) {
        this.point2 = point2;
    }

    public void setBrush(Brush brush) {
        this.brush = brush;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void draw(ShapeType shapeType) {
        Shape shape = this.shapeFactory.createShape(shapeType);
        shape.setPoint1(this.point1.x, this.point1.y);
        shape.setPoints2(this.point2.x, this.point2.y);
        GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
        graphicsContext.setLineWidth(this.brush.getWidth());
        graphicsContext.setStroke(this.brush.getColor());
        shape.draw(graphicsContext, this.brush.getColor(), brush.getWidth());
    }
}
