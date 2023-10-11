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
    private static final EditorStateSingleton editorStateSingleton = EditorStateSingleton.getInstance();

    public static void save() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(JsonParser.defaultFilePath), editorStateSingleton.getCreatedShapes());
    }

    public static HashMap<String, ArrayList<Shape>> load() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, ArrayList<Shape>>> typeRef = new TypeReference<>() {
        };
        objectMapper.registerModule(new ShapeModule());

        return objectMapper.readValue(new File(JsonParser.defaultFilePath), typeRef);
    }

    public static void loadToState() throws IOException {
        editorStateSingleton.setCreatedShapes(load());
    }

    public static void setDefaultFilePath(String defaultFilePath) {
        JsonParser.defaultFilePath = defaultFilePath;
    }

    public static String getDefaultFilePath() {
        return defaultFilePath;
    }
}
