package com.example.paint.interactors.actions;

import com.example.paint.interactors.states.EditorStateSingleton;
import javafx.scene.layout.Pane;

public class ClearShapesAction {
    public static void run(Pane pane){
        pane.getChildren().clear();
        EditorStateSingleton editorState = EditorStateSingleton.getInstance();
        editorState.clearShapes();
    }
}
