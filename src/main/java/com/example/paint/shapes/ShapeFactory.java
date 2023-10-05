package com.example.paint.shapes;

public class ShapeFactory {
    public static Shape createShape (ShapeType type) {
        Shape shape = null;

        switch (type) {
            case BRUSH:
                shape = new Square();
                break;
            case CIRCLE:
                shape = new Circle();
            case LINE:
                shape = new Line();
            case OVAL:
                shape = new Oval();
            case RECTANGLE:
                shape = new Rectangle();
            case SQUARE:
                shape = new Square();
        }

        return shape;
    }
}
