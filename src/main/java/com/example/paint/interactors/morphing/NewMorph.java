package com.example.paint.interactors.morphing;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class NewMorph {
    private List<Polygon> interpolatedPolygons = new ArrayList<>();
    private int numSteps = 100; // количество этапов преобразования

    public void make(Pane root, Polygon startPolygon, Polygon endPolygon, int desiredStep) {
        interpolatePoints(startPolygon, endPolygon);
        Polygon polygon = new Polygon();
        polygon.setFill(Color.TRANSPARENT);
        polygon.setStroke(Color.BLACK);
        root.getChildren().add(polygon);

        Timeline timeline = new Timeline();
        for (int step = 0; step < numSteps; step++) {
            Polygon currentPolygon = interpolatedPolygons.get(step);
            if (step == desiredStep) {
                polygon.getPoints().setAll(currentPolygon.getPoints());
            }
            int currentStep = step; // создаем копию переменной для использования внутри лямбда-выражения
            KeyFrame keyFrame = new KeyFrame(Duration.millis(10000 * step), event -> {
                if (currentStep == desiredStep) {
                    System.out.println("Этап " + currentStep + ": " + interpolatedPolygons.get(currentStep).getPoints());
                }
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();
    }

    private void interpolatePoints(Polygon startPolygon, Polygon endPolygon) {
        int startSize = startPolygon.getPoints().size() / 2;
        int endSize = endPolygon.getPoints().size() / 2;
        List<Point2D> startPoints = getPolygonPoints(startPolygon);
        List<Point2D> endPoints = getPolygonPoints(endPolygon);

        double[] startX = new double[startSize];
        double[] startY = new double[startSize];
        double[] endX = new double[endSize];
        double[] endY = new double[endSize];

        for (int i = 0; i < startSize; i++) {
            startX[i] = startPoints.get(i).getX();
            startY[i] = startPoints.get(i).getY();
        }

        for (int i = 0; i < endSize; i++) {
            endX[i] = endPoints.get(i).getX();
            endY[i] = endPoints.get(i).getY();
        }

        for (int step = 0; step < numSteps; step++) {
            double t = (double) step / (numSteps - 1); // интерполяционный параметр от 0 до 1
            Polygon interpolated = new Polygon();
            for (int i = 0; i < Math.max(startSize, endSize); i++) {
                double x = (1 - t) * (i < startSize ? startX[i] : 0) + t * (i < endSize ? endX[i] : 0); // интерполяция координаты x
                double y = (1 - t) * (i < startSize ? startY[i] : 0) + t * (i < endSize ? endY[i] : 0); // интерполяция координаты y
                interpolated.getPoints().addAll(x, y);
            }
            interpolatedPolygons.add(interpolated);
        }
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