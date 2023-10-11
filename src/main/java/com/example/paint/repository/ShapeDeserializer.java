package com.example.paint.repository;

import com.example.paint.interactors.shapes.Circle;
import com.example.paint.interactors.shapes.Shape;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class ShapeDeserializer extends StdDeserializer<Shape> {
    public ShapeDeserializer() {
        super(Shape.class);
    }

    public Shape deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        return jsonParser.readValueAs(Circle.class);
    }
}
