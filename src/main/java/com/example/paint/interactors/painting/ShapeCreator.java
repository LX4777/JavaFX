package com.example.paint.interactors.painting;

import javafx.scene.shape.Shape;

public abstract class ShapeCreator<MyShape> {
    abstract Shape make(MyShape shape);
}
