package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Circle;

public class CircleCreator extends ShapeCreator<Circle> {
    javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle();

    public javafx.scene.shape.Circle make(com.example.paint.interactors.shapes.Circle shape) {
        shape.setWidth(shape.getHeight());
        circle.setRadius(shape.getWidth() / 2);
        return circle;
    }
}
