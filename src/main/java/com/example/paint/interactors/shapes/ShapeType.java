package com.example.paint.interactors.shapes;

import javafx.util.StringConverter;

public enum ShapeType {
    LINE("Линия"),
    CIRCLE("Круг"),
    OVAL("Овал"),
    SQUARE("Квадрат"),
    RECTANGLE("Прямоугольник");

    private final String label;

    ShapeType(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getLabel() {
        return label;
    }

    public static ShapeType getByLatinName(String string) {
        return ShapeType.valueOf(string);
    }

    public static StringConverter<ShapeType> converter() {
        return new StringConverter<ShapeType>() {
            @Override
            public String toString(ShapeType type) {
                return type.getLabel();
            }

            @Override
            public ShapeType fromString(String string) {
                return ShapeType.getByLatinName(string);
            }
        };
    }
}
