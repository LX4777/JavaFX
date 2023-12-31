package com.example.paint.interactors.states;

import com.example.paint.interactors.shapes.*;

import java.util.ArrayList;
import java.util.HashMap;

public class EditorStateSingleton {
    private StateType stateType;

    private static EditorStateSingleton instance;
    private HashMap<String, ArrayList<Shape>> createdShapes = new HashMap<>();

    private EditorStateSingleton() {
        this.stateType = StateType.DRAWING;
        setDefaultCreatedShapes();
    }

    private void setDefaultCreatedShapes() {
        for (ShapeType shapeType : ShapeType.values()) {
            createdShapes.put(shapeType.name(), new ArrayList<Shape>());
        }
    }

    public static EditorStateSingleton getInstance() {
        if (instance == null) {
            instance = new EditorStateSingleton();
        }
        return instance;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void addShape(Shape shape) {
        if (shape instanceof Circle) {
            ArrayList<Shape> shapes = createdShapes.get(String.valueOf(ShapeType.CIRCLE));
            shapes.add(shape);
        } else if (shape instanceof Rectangle) {
            ArrayList<Shape> shapes = createdShapes.get(String.valueOf(ShapeType.RECTANGLE));
            shapes.add(shape);
        } else if (shape instanceof Oval) {
            ArrayList<Shape> shapes = createdShapes.get(String.valueOf(ShapeType.OVAL));
            shapes.add(shape);
        } else if (shape instanceof Line) {
            ArrayList<Shape> shapes = createdShapes.get(String.valueOf(ShapeType.LINE));
            shapes.add(shape);
        } else if (shape instanceof Square) {
            ArrayList<Shape> shapes = createdShapes.get(String.valueOf(ShapeType.SQUARE));
            shapes.add(shape);
        } else if (shape instanceof Star) {
            ArrayList<Shape> shapes = createdShapes.get(String.valueOf(ShapeType.STAR));
            shapes.add(shape);
        }
        System.out.println("Стейт: " + createdShapes);
    }

    public void setCreatedShapes(HashMap<String, ArrayList<Shape>> createdShapes) {
        this.createdShapes = createdShapes;
    }

    public HashMap<String, ArrayList<Shape>> getCreatedShapes() {
        return createdShapes;
    }

    public void clearShapes() {
        setDefaultCreatedShapes();
    }

    public boolean isDrawing() {
        return this.stateType == StateType.DRAWING;
    }

    public boolean isDragging() {
        return this.stateType == StateType.DRAG_AND_DROP;
    }
}
