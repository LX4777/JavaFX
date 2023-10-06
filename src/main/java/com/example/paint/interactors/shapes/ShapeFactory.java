package com.example.paint.interactors.shapes;

public class ShapeFactory {
    public Shape createShape (ShapeType type) {

        return switch (type) {
            case CIRCLE -> new Circle();
            case LINE -> new Line();
            case OVAL -> new Oval();
            case RECTANGLE -> new Rectangle();
            case SQUARE -> new Square();
        };
    }
}
