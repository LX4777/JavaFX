package com.example.paint.repository;

import com.example.paint.interactors.shapes.Shape;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class ShapeModule extends SimpleModule {
    {
        addDeserializer(Shape.class, new ShapeDeserializer());
    }
}

