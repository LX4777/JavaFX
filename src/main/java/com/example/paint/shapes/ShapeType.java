package com.example.paint.shapes;

public enum ShapeType {
    PENCIL("Карандаш"),
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
