package com.example.paint.repository;

import com.example.paint.interactors.shapes.Shape;
import com.example.paint.interactors.states.EditorStateSingleton;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonParser {
    private static String defaultFilePath = "saves/save.json";

    public static void save() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EditorStateSingleton editorStateSingleton = EditorStateSingleton.getInstance();
        objectMapper.writeValue(new File(JsonParser.defaultFilePath), editorStateSingleton.getCreatedShapes());
    }

    public static void load() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EditorStateSingleton editorStateSingleton = EditorStateSingleton.getInstance();
        TypeReference<HashMap<String, ArrayList<Shape>>> typeRef = new TypeReference<>() {
        };
        objectMapper.registerModule(new ShapeModule());
        editorStateSingleton.setCreatedShapes(objectMapper.readValue(new File(JsonParser.defaultFilePath), typeRef));
    }

    public static void setDefaultFilePath(String defaultFilePath) {
        JsonParser.defaultFilePath = defaultFilePath;
    }

    public static String getDefaultFilePath() {
        return defaultFilePath;
    }
}
