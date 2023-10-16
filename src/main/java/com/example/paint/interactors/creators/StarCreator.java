package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Star;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class StarCreator extends ShapeCreator<Star> {
    Polygon star = new Polygon();

    private static final int STAR_SIZE = 200; // Размер звезды

    public Polygon make(Star shape) {
        // Создаем пятиконечную звезду
        Polygon star = createStar(STAR_SIZE);
        star.setLayoutX((800 - STAR_SIZE) / 2); // Расположение звезды по горизонтали
        star.setLayoutY((600 - STAR_SIZE) / 2); // Расположение звезды по вертикали

        return star;
    }

    // Метод для создания пятиконечной звезды
    private Polygon createStar(double size) {
        Polygon star = new Polygon();

        // Вычисляем координаты вершин звезды
        double centerX = size / 2;
        double centerY = size / 2;
        double outerRadius = size / 2;
        double innerRadius = size / 4;

        for (int i = 0; i < 5; i++) {
            double outerX = centerX + outerRadius * Math.cos(Math.toRadians(i * 72));
            double outerY = centerY + outerRadius * Math.sin(Math.toRadians(i * 72));
            star.getPoints().addAll(outerX, outerY);

            double innerX = centerX + innerRadius * Math.cos(Math.toRadians((i * 72) + 36));
            double innerY = centerY + innerRadius * Math.sin(Math.toRadians((i * 72) + 36));
            star.getPoints().addAll(innerX, innerY);
        }

        star.setFill(Color.YELLOW); // Цвет звезды

        return star;
    }
}
