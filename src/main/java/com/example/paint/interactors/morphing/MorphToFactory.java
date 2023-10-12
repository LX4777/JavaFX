package com.example.paint.interactors.morphing;

import com.example.paint.interactors.shapes.ShapeType;

public class MorphToFactory {
    public static MorphTo createMorph(ShapeType type) {
        return switch (type) {
            case CIRCLE -> new MorphToCircle();
            case LINE -> new MorphToLine();
            case OVAL -> new MorphToOval();
            case RECTANGLE -> new MorphToRectangle();
            case SQUARE -> new MorphToSquare();
            case STAR -> new MorphToStar();
        };
    }
}
