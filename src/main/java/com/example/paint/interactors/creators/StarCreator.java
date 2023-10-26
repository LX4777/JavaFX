package com.example.paint.interactors.creators;

import com.example.paint.interactors.shapes.Star;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class StarCreator extends ShapeCreator<Star> {
    Polygon star = new Polygon();

    private static final double STAR_SIZE = 200;

    public Polygon make(Star shape) {
        Polygon star = createStar();
        star.setLayoutX((800 - STAR_SIZE) / 2);
        star.setLayoutY((600 - STAR_SIZE) / 2);

        return star;
    }

    private Polygon createStar() {
        double centerX = STAR_SIZE / 2;
        double centerY = STAR_SIZE / 2;
        double outerRadius = STAR_SIZE / 2;
        double innerRadius = STAR_SIZE / 4;

        for (int i = 0; i < 5; i++) {
            double outerX = centerX + outerRadius * Math.cos(Math.toRadians(i * 72));
            double outerY = centerY + outerRadius * Math.sin(Math.toRadians(i * 72));
            star.getPoints().addAll(outerX, outerY);

            double innerX = centerX + innerRadius * Math.cos(Math.toRadians((i * 72) + 36));
            double innerY = centerY + innerRadius * Math.sin(Math.toRadians((i * 72) + 36));
            star.getPoints().addAll(innerX, innerY);
        }

        star.setFill(Color.YELLOW);

        return star;
    }
}
