package com.example.paint.interactors.dragging;

import com.example.paint.interactors.shapes.ShapeType;

public class DraggingFactory {
    public static IDragging createDraggingEffect(ShapeType type) {
        return switch (type) {
            case CIRCLE -> new CircleDragging();
            case LINE -> new LineDragging();
            case OVAL -> new EllipseDragging();
            case RECTANGLE -> new RectangleDragging();
            case SQUARE -> new SquareDragging();
            case STAR -> new StarDragging();
        };
    }
}
