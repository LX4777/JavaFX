package com.example.paint.shapes;

public enum Shapes {
    BRUSH("Кисть"),
    LINE("Линия"),
    CIRCLE("Круг"),
    OVAL("Овал"),
    SQUARE("Квадрат"),
    RECTANGLE("Прямоугольник");

    private final String label;

    Shapes(String label) {
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
