package com.example.paint.interactors.dragging;

import com.example.paint.interactors.states.EditorStateSingleton;
import com.example.paint.interactors.states.StateType;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

public abstract class ShapeDragging<T> implements IDragging {
    double orgSceneX, orgSceneY;
    double offsetX, offsetY;

    public void setDragAndDrop(Shape shape) {
        shape.setOnMousePressed(shapeOnMousePressedEventHandler);
        shape.setOnMouseDragged(shapeOnMouseDraggedEventHandler);
    }

    protected abstract void setX(T shape);

    protected abstract void setY(T shape);

    EventHandler<MouseEvent> shapeOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
        final EditorStateSingleton editorState = EditorStateSingleton.getInstance();

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (editorState.getStateType() == StateType.DRAWING) return;
            orgSceneX = mouseEvent.getSceneX();
            orgSceneY = mouseEvent.getSceneY();
            Shape shape = (Shape) (mouseEvent.getSource());
            shape.toFront();
        }
    };

    EventHandler<MouseEvent> shapeOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        final EditorStateSingleton editorState = EditorStateSingleton.getInstance();

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (editorState.getStateType() == StateType.DRAWING) return;

            offsetX = mouseEvent.getSceneX() - orgSceneX;
            offsetY = mouseEvent.getSceneY() - orgSceneY;

            T shape = (T) (mouseEvent.getSource());
            setX(shape);
            setY(shape);

            orgSceneX = mouseEvent.getSceneX();
            orgSceneY = mouseEvent.getSceneY();
        }
    };

}
