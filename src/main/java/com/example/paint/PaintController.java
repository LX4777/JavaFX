package com.example.paint;

import com.example.paint.painting.Brush;
import com.example.paint.painting.Drawer;
import com.example.paint.shapes.*;
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
    private CheckBox pencil;

    @FXML
    private ChoiceBox<ShapeType> figureSelect;

    private final ObservableList<ShapeType> figures = FXCollections.observableArrayList(ShapeType.values());

    public void initialize() {
        figureSelect.setItems(figures);
        figureSelect.setValue(figures.get(0));
        figureSelect.setTooltip(new Tooltip("Выберите фигуру"));
        GraphicsContext g = this.canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (this.eraser.isSelected()) {
                g.clearRect(x, y, size, size);
                return;
            }

            if (pencil.isSelected()) {
                g.setFill(colorPicker.getValue());
                g.setStroke(colorPicker.getValue());
                g.fillOval(x, y, size, size);
            }
        });

        Drawer drawer = new Drawer();

        this.canvas.setOnMousePressed(e -> {
            double x1 = e.getX();
            double y1 = e.getY();
            drawer.setPoint1(new Coordinate(x1, y1));
        });

        this.canvas.setOnMouseReleased(e2 -> {
            System.out.println(this.canvas.getUserData());
            if (this.eraser.isSelected()) {
                return;
            }

            double x2 = e2.getX();
            double y2 = e2.getY();
            drawer.setPoint2(new Coordinate(x2, y2));

            drawer.setBrush(new Brush(colorPicker.getValue(), Double.parseDouble(brushSize.getText())));
            drawer.setCanvas(canvas);

            if (!pencil.isSelected()) {
                drawer.draw(figureSelect.getValue());
            }
        });
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