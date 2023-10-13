package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Star;
import javafx.collections.ObservableList;
import javafx.scene.shape.Polygon;

public class StarCreator extends ShapeCreator<Star> {
    Polygon star = new Polygon();

    public Polygon make(Star shape) {
        shape.setWidth(shape.getHeight());

        double starSize = 200; // Размер звезды

        // Создаем объект класса Polygon
        Polygon star = new Polygon();
        ObservableList<Double> points = star.getPoints();

        calculateStarPoints(points, starSize);

        return star;
    }

    private void calculateStarPoints(ObservableList<Double> points, double size) {
        double centerX = size / 2;
        double centerY = size / 2;
        double outerRadius = size / 2;
        double innerRadius = size / 4;

        for (int i = 0; i < 5; i++) {
            double outerAngle = Math.PI * 2 * i / 5 - Math.PI / 2;
            double innerAngle = outerAngle + Math.PI / 5;
            points.addAll(
                    centerX + Math.cos(outerAngle) * outerRadius,
                    centerY + Math.sin(outerAngle) * outerRadius,
                    centerX + Math.cos(innerAngle) * innerRadius,
                    centerY + Math.sin(innerAngle) * innerRadius
            );
        }
    }
}
