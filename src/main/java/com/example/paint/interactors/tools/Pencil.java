package com.example.paint.interactors.tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pencil {
    public static void start(Canvas canvas, double x, double y, double size, Color color) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(color);
        g.setStroke(color);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }
}
