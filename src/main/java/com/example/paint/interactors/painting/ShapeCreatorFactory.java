package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.ShapeType;

public class ShapeCreatorFactory {
    public static ShapeCreator make(ShapeType type) {
        return switch (type) {
            case CIRCLE -> new CircleCreator();
            case LINE -> new LineCreator();
            case OVAL -> new OvalCreator();
            case RECTANGLE -> new RectangleCreator();
            case SQUARE -> new SquareCreator();
        };
    }
}
