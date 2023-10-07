package com.example.paint.interactors.painting;

import com.example.paint.interactors.shapes.ShapeType;

public class DrawFactory {
    public static Draw createDraw(ShapeType type) {
        return switch (type) {
            case CIRCLE -> new DrawCircle();
            case LINE -> new DrawLine();
            case OVAL -> new DrawOval();
            case RECTANGLE -> new DrawRectangle();
            case SQUARE -> new DrawSquare();
        };
    }
}
