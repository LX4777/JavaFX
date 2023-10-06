package com.example.paint.interactors.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pencil extends ShapeWithSize {
    //TODO: Переделать, возможно создать класс Tool, и от него наследоваться
    @Override
    public void draw(GraphicsContext graphicsContext, Color color, double size) {
        super.draw(graphicsContext, color, size);
        graphicsContext.strokeOval(startCoordinate.getX(), startCoordinate.getY(), width, height);
    }
}
