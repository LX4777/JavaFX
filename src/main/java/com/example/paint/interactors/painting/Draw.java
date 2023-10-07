package com.example.paint.interactors.painting;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class Draw<MyShape extends com.example.paint.interactors.shapes.Shape> {
    abstract Shape draw(Pane pane, MyShape shape, Brush brush);
}
