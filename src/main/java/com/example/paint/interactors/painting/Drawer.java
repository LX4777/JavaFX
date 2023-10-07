package com.example.paint.interactors.painting;

import com.example.paint.interactors.dragging.DraggingFactory;
import com.example.paint.interactors.dragging.IDragging;
import com.example.paint.interactors.shapes.Coordinate;
import com.example.paint.interactors.shapes.Shape;
import com.example.paint.interactors.shapes.ShapeFactory;
import com.example.paint.interactors.shapes.ShapeType;
import javafx.scene.layout.Pane;

public class Drawer {
    protected Brush brush;
    protected Pane pane;
    protected ShapeFactory shapeFactory;

    protected Coordinate point1;
    protected Coordinate point2;

    public Drawer() {
        this.brush = new Brush();
        this.pane = new Pane();
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

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public void draw(ShapeType shapeType) {
        Shape shape = this.shapeFactory.createShape(shapeType);
        shape.setPoint1(this.point1.getX(), this.point1.getY());
        shape.setPoint2(this.point2.getX(), this.point2.getY());

        IDragging dragging = DraggingFactory.createDraggingEffect(shapeType);

//        GraphicsContext graphicsContext = this.pane.getGraphicsContext2D();
//        graphicsContext.setLineWidth(this.brush.getWidth());
//        graphicsContext.setStroke(this.brush.getColor());
        shape.draw(pane, brush);
    }
}
