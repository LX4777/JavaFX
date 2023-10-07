package com.example.paint.interactors.shapes;

import com.example.paint.interactors.painting.Brush;
import com.example.paint.interactors.states.EditorStateSingleton;
import com.example.paint.interactors.states.StateType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Square extends ShapeWithSize {
    double orgSceneX, orgSceneY;

    @Override
    public void draw(Pane pane, Brush brush) {
        super.draw(pane, brush);
        this.width = this.height;
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(this.width, this.height, brush.getFillColor());
        rectangle.setStrokeWidth(brush.getWidth());
        rectangle.setStroke(brush.getColor());
        rectangle.setOnMousePressed(shapeOnMousePressedEventHandler);
        rectangle.setOnMouseDragged(shapeOnMouseDraggedEventHandler);
        rectangle.relocate(this.startCoordinate.getX(), this.startCoordinate.getY());
        pane.getChildren().add(rectangle);
    }

    EventHandler<MouseEvent> shapeOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
        final EditorStateSingleton editorState = EditorStateSingleton.getInstance();
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (editorState.getStateType() == StateType.DRAWING) return;
            orgSceneX = mouseEvent.getSceneX();
            orgSceneY = mouseEvent.getSceneY();
            javafx.scene.shape.Rectangle shape = (javafx.scene.shape.Rectangle) (mouseEvent.getSource());
            shape.toFront();
        }
    };

    EventHandler<MouseEvent> shapeOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        final EditorStateSingleton editorState = EditorStateSingleton.getInstance();
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (editorState.getStateType() == StateType.DRAWING) return;
            double offsetX = mouseEvent.getSceneX() - orgSceneX;
            double offsetY = mouseEvent.getSceneY() - orgSceneY;
            javafx.scene.shape.Rectangle shape = (javafx.scene.shape.Rectangle) (mouseEvent.getSource());

            shape.setX(shape.getX() + offsetX);
            shape.setY(shape.getY() + offsetY);

            orgSceneX = mouseEvent.getSceneX();
            orgSceneY = mouseEvent.getSceneY();
        }
    };
}
