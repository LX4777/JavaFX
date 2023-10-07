package com.example.paint.interactors.painting;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class Draw<MyShape> {
    abstract Shape draw(Pane pane, MyShape shape, Brush brush);
}
