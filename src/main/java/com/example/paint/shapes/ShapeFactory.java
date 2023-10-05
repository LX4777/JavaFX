package com.example.paint.shapes;

public class ShapeFactory {
    public Shape createShape (ShapeType type) {

        return switch (type) {
            case PENCIL -> new Pencil();
            case CIRCLE -> new Circle();
            case LINE -> new Line();
            case OVAL -> new Oval();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
        };
    }
}
