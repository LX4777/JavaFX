package com.example.paint.interactors.shapes;

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
}
