package com.example.paint;

import com.example.paint.painting.Drawer;
import com.example.paint.shapes.Circle;
import com.example.paint.shapes.Square;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

import java.io.File;

public class PaintController {
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox eraser;


    public void initialize() {
        Drawer drawer = new Drawer();
        drawer.run(canvas, colorPicker, new Circle());

//        GraphicsContext g = this.canvas.getGraphicsContext2D();
//
//        canvas.setOnMousePressed(e -> {
//            double x1 = e.getX();
//            double y1 = e.getY();
//
//            canvas.setOnMouseReleased(e2 -> {
//                double x2 = e2.getX();
//                double y2 = e2.getY();
//                g.setStroke(colorPicker.getValue());
//                double dx = (x2 > x1) ? x2 - x1 : x1 - x2;
//                double dy = (y2 > y1) ? y2 - y1 : y1 - y2;
//
//                g.strokeRect(x1, y1, dx, dy);
//            });
//        });

//        canvas.setOnMouseDragged(e -> {
//            double size = Double.parseDouble(brushSize.getText());
//            double x = e.getX() - size / 2;
//            double y = e.getY() - size / 2;
//
//            if (this.eraser.isSelected()) {
//                g.clearRect(x, y, size, size);
//            } else {
//              //  g.setFill(colorPicker.getValue());
//               g.setStroke(colorPicker.getValue());
//                g.strokeRect(x, y, size, size);
//            }
//        });

    }

    @FXML
    public void onSave() {
        try {
            Image snapshot = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("saves/save.png"));
        } catch (Exception e) {
            System.out.println("Не удалось сохранить: " + e.getMessage());
        }
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }
}