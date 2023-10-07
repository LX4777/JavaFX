package com.example.paint.presentation;

import com.example.paint.interactors.actions.InitializeShapesSelectAction;
import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.painting.Drawer;
import com.example.paint.interactors.shapes.*;
import com.example.paint.interactors.tools.Eraser;
import com.example.paint.interactors.tools.Pencil;
import com.example.paint.repository.Snapshot;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class PaintController {
//    @FXML
//    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField brushSize;

    @FXML
    private CheckBox eraser;

    @FXML
    private CheckBox pencil;

    @FXML
    private ChoiceBox<ShapeType> shapesSelect;

    @FXML Group root;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    public void initialize() {
        InitializeShapesSelectAction.start(shapesSelect);

        Canvas canvas1 = new Canvas(150,150);
        GraphicsContext graphicsContext1 = canvas1.getGraphicsContext2D();
        graphicsContext1.setFill(Color.BLACK);
        graphicsContext1.fillOval(50,50,100,100);
        canvas1.setOnMousePressed(canvasOnMousePressedEventHandler);
        canvas1.setOnMouseDragged(canvasOnMouseDraggedEventHandler);

        Canvas canvas2 = new Canvas(300, 300);
        GraphicsContext graphicsContext2 = canvas2.getGraphicsContext2D();
        graphicsContext2.setFill(Color.BLACK);
        graphicsContext2.fillOval(150,150,100,100);
        canvas2.setOnMousePressed(canvasOnMousePressedEventHandler);
        canvas2.setOnMouseDragged(canvasOnMouseDraggedEventHandler);

        root.getChildren().add(canvas1);
        root.getChildren().add(canvas2);

//        canvas.setOnMouseDragged(e -> {
//            if (this.eraser.isSelected()) {
//                Eraser.start(canvas, e.getX(), e.getY(), Double.parseDouble(brushSize.getText()));
//                return;
//            }
//
//            if (pencil.isSelected()) {
//                Pencil.start(canvas, e.getX(), e.getY(), Double.parseDouble(brushSize.getText()), colorPicker.getValue());
//            }
//        });
//
//        Drawer drawer = new Drawer();
//
//        this.canvas.setOnMousePressed(e -> {
//            drawer.setPoint1(new Coordinate(e.getX(), e.getY()));
//        });
//
//        this.canvas.setOnMouseReleased(e -> {
//            if (this.eraser.isSelected()) return;
//
//            drawer.setPoint2(new Coordinate(e.getX(), e.getY()));
//            drawer.setBrush(new Brush(colorPicker.getValue(), Double.parseDouble(brushSize.getText())));
//            drawer.setCanvas(canvas);
//
//            if (!pencil.isSelected()) {
//                drawer.draw(shapesSelect.getValue());
//            }
//        });
    }
    EventHandler<MouseEvent> canvasOnMousePressedEventHandler = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            orgSceneX = mouseEvent.getSceneX();
            orgSceneY = mouseEvent.getSceneY();
            orgTranslateX = ((Canvas)(mouseEvent.getSource())).getTranslateX();
            orgTranslateY = ((Canvas) (mouseEvent.getSource())).getTranslateY();
        }
    };

    EventHandler<MouseEvent> canvasOnMouseDraggedEventHandler = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            double offsetX = mouseEvent.getSceneX() - orgSceneX;
            double offsetY = mouseEvent.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;

            ((Canvas) (mouseEvent.getSource())).setTranslateX(newTranslateX);  //transform the object
            ((Canvas) (mouseEvent.getSource())).setTranslateY(newTranslateY);
        }
    };

    @FXML
    public void onSnapshot() {
//        Snapshot.make(canvas);
    }

    @FXML
    public void onExit() {
        Platform.exit();
    }
}