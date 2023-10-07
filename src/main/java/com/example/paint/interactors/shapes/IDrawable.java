package com.example.paint.interactors.shapes;

import com.example.paint.interactors.painting.Brush;
import javafx.scene.layout.Pane;

public interface IDrawable {
    void draw(Pane pane, Brush brush);
}
