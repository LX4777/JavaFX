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
        createdShapes.put("Circle", new ArrayList<>());
        createdShapes.put("Square", new ArrayList<>());
        createdShapes.put("Oval", new ArrayList<>());
        createdShapes.put("Line", new ArrayList<>());
        createdShapes.put("Rectangle", new ArrayList<>());
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
            ArrayList<Shape> shapes = createdShapes.get("Circle");
            shapes.add(shape);
        } else if (shape instanceof Rectangle) {
            ArrayList<Shape> shapes = createdShapes.get("Rectangle");
            shapes.add(shape);
        } else if (shape instanceof Oval) {
            ArrayList<Shape> shapes = createdShapes.get("Oval");
            shapes.add(shape);
        } else if (shape instanceof Line) {
            ArrayList<Shape> shapes = createdShapes.get("Line");
            shapes.add(shape);
        } else if (shape instanceof Square) {
            ArrayList<Shape> shapes = createdShapes.get("Square");
            shapes.add(shape);
        }
        System.out.println(createdShapes);
    }

    public void setCreatedShapes(HashMap<String, ArrayList<Shape>> createdShapes) {
        this.createdShapes = createdShapes;
    }

    public HashMap<String, ArrayList<Shape>> getCreatedShapes() {
        return createdShapes;
    }
}
