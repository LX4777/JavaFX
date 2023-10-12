package com.example.paint.interactors.actions;

import com.example.paint.interactors.shapes.Shape;
import com.example.paint.interactors.states.EditorStateSingleton;
import com.example.paint.repository.JsonParser;
import com.example.paint.repository.ShapesRestorer;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadShapesAction {
    public static void run(Pane pane) throws IOException {
        EditorStateSingleton editorState = EditorStateSingleton.getInstance();
        editorState.clearShapes();
        System.out.println("Содержимое панели" + pane.getChildren());

        HashMap<String, ArrayList<Shape>> shapes = JsonParser.load();
        ShapesRestorer.restore(pane, shapes);
    }
}
