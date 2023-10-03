package com.example.paint.painting;

import com.example.paint.shapes.Shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class Drawer {
    public void run(Canvas canvas, ColorPicker colorPicker, Shape shape, TextField brushSize) {
        GraphicsContext g = canvas.getGraphicsContext2D();
        canvas.setOnMousePressed(e -> {
            double x1 = e.getX();
            double y1 = e.getY();
            shape.setPoint1(x1, y1);
        });
        canvas.setOnMouseReleased(e2 -> {
            double x2 = e2.getX();
            double y2 = e2.getY();
            shape.setPoints2(x2,y2);
            shape.draw(g, colorPicker.getValue(), Double.parseDouble(brushSize.getText()));
        });
    }
}
