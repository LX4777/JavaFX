package com.example.paint.interactors.morphing;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class NewMorph {
    private List<Polygon> interpolatedPolygons = new ArrayList<>();

    private int numSteps = 100; // количество этапов преобразования
//    private int desiredStep = 100; // номер этапа, который хотим увидеть

    public void make(Pane root, Polygon startPolygon, Polygon endPolygon, int desiredStep){
        interpolatePoints(startPolygon, endPolygon);

        Polygon polygon = new Polygon();
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);

        Timeline timeline = new Timeline();
        for (int step = 0; step < numSteps; step++) {
            Polygon currentPolygon = interpolatedPolygons.get(step);
            polygon.getPoints().addAll(currentPolygon.getPoints());

            int currentStep = step; // создаем копию переменной для использования внутри лямбда-выражения
            KeyFrame keyFrame = new KeyFrame(Duration.millis(10000 * step), event -> {
                if (currentStep == desiredStep) {
                    System.out.println("Этап " + currentStep + ": " + interpolatedPolygons.get(currentStep).getPoints());
                }
            });

            timeline.getKeyFrames().add(keyFrame);
        }

        root.getChildren().add(polygon);

        timeline.play();
    }
    private void interpolatePoints(Polygon startPolygon, Polygon endPolygon) {
        int maxSize = Math.max(startPolygon.getPoints().size() / 2, endPolygon.getPoints().size() / 2);
        List<Point2D> startPoints = getPolygonPoints(startPolygon);
        List<Point2D> endPoints = getPolygonPoints(endPolygon);

        for (int step = 0; step < numSteps; step++) {
            double t = (double) step / (numSteps - 1); // интерполяционный параметр от 0 до 1
            Polygon interpolated = new Polygon();

            for (int i = 0; i < maxSize; i++) {
                Point2D startPoint = i < startPoints.size() ? startPoints.get(i) : new Point2D(0, 0);
                Point2D endPoint = i < endPoints.size() ? endPoints.get(i) : new Point2D(0, 0);
                double x = (1 - t) * startPoint.getX() + t * endPoint.getX(); // интерполяция координаты x
                double y = (1 - t) * startPoint.getY() + t * endPoint.getY(); // интерполяция координаты y
                interpolated.getPoints().addAll(x, y);
            }

            interpolatedPolygons.add(interpolated);
        }
    }

    private Polygon createStartPolygon() {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(0.0, 0.0, 2.0, 0.0, 2.0, 2.0, 0.0, 2.0);
        return polygon;
    }

    private Polygon createEndPolygon() {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(1.0, 1.0, 3.0, 1.0, 3.0, 3.0, 1.0, 3.0);
        return polygon;
    }

    private List<Point2D> getPolygonPoints(Polygon polygon) {
        List<Point2D> points = new ArrayList<>();
        for (int i = 0; i < polygon.getPoints().size(); i += 2) {
            double x = polygon.getPoints().get(i);
            double y = polygon.getPoints().get(i + 1);
            points.add(new Point2D(x, y));
        }
        return points;
    }
}
