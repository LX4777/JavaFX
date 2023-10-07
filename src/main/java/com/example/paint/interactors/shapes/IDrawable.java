package com.example.paint.interactors.shapes;

import com.example.paint.interactors.painting.Brush;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public interface IDrawable {
    Shape draw(Pane pane, Brush brush);
}
