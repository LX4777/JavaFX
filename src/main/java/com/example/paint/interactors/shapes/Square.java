package com.example.paint.interactors.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ShapeWithSize {
    @Override
    public void draw(GraphicsContext graphicsContext) {
        super.draw(graphicsContext);
        this.width = this.height;
        graphicsContext.strokeRect(startCoordinate.getX(), startCoordinate.getY(), width, width);
    }
}
