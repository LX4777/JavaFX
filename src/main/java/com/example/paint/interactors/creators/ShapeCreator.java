package com.example.paint.interactors.creators;

import javafx.scene.shape.Shape;

public abstract class ShapeCreator<MyShape> {
    public abstract Shape make(MyShape shape);
}
