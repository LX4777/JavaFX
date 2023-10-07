package com.example.paint.interactors.painting;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public interface IDraw {
    Shape draw(Pane pane, com.example.paint.interactors.shapes.Shape shape, Brush brush);
}
