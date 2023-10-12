package com.example.paint.interactors.actions;

import com.example.paint.repository.JsonParser;

import java.io.IOException;

public class SaveShapesAction {
    public static void run() throws IOException {
        JsonParser.save();
    }
}
