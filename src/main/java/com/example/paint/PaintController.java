package com.example.paint;

import com.example.paint.painting.Drawer;
import com.example.paint.shapes.Circle;
import com.example.paint.shapes.Line;
import com.example.paint.shapes.Square;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;

import java.io.File;
import java.util.Objects;

public class PaintController {
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox eraser;

    @FXML
    private ChoiceBox<String> figureSelect;

    public void initialize() {
        ObservableList<String> figures = FXCollections.observableArrayList("Кисть", "Линия", "Круг", "Овал", "Квадрат", "Прямоугольник");
        figureSelect.setItems(figures);
        figureSelect.setValue(figures.get(1));
        figureSelect.setTooltip(new Tooltip("Выберите фигуру"));

        GraphicsContext g = this.canvas.getGraphicsContext2D();
        if (Objects.equals(figureSelect.getValue(), figures.get(0))) {
            System.out.println(Objects.equals(figureSelect.getValue(), figures.get(0)));
            canvas.setOnMouseDragged(e -> {
                double size = Double.parseDouble(brushSize.getText());
                double x = e.getX() - size / 2;
                double y = e.getY() - size / 2;

                if (this.eraser.isSelected()) {
                    g.clearRect(x, y, size, size);
                } else {
                    g.setFill(colorPicker.getValue());
                    g.setStroke(colorPicker.getValue());
                    g.fillOval(x, y, size, size);
                }
            });
        } else {
            Drawer drawer = new Drawer();
            drawer.run(canvas, colorPicker, new Line(), brushSize);
        }

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