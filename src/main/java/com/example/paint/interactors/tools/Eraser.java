package com.example.paint.interactors.tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Eraser {
    public static void start(Canvas canvas, double x, double y, double size) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.clearRect(x - size / 2, y - size / 2, size, size);
    }
}
