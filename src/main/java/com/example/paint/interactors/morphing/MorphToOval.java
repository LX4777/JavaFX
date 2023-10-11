package com.example.paint.interactors.morphing;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class MorphToOval extends MorphTo {
    public void morph(Shape shape) {
        Ellipse clipShape = new Ellipse();

        KeyFrame firstFrame = new KeyFrame(Duration.seconds(3));

        if (shape instanceof Rectangle rectangle) {
            clipShape.setRadiusX((rectangle.getWidth() / 2) * 1.5);
            clipShape.setRadiusY((rectangle.getHeight() / 2) * 1.5);
            rectangle.setClip(clipShape);
            double offsetX = clipShape.getRadiusX() - rectangle.getWidth() / 2;
            double offsetY = clipShape.getRadiusY() - rectangle.getHeight() / 2;
            clipShape.relocate(-offsetX, -offsetY);
            firstFrame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(clipShape.radiusXProperty(), rectangle.getWidth() == rectangle.getHeight() ? ((rectangle.getWidth() / 2) / 2) : rectangle.getWidth() / 2), new KeyValue(clipShape.radiusYProperty(), rectangle.getHeight() / 2));
        } else if (shape instanceof Ellipse ellipse) {
            double maxSize = Math.max(ellipse.getRadiusX(), ellipse.getRadiusY());
            clipShape.setRadiusX(maxSize);
            clipShape.setRadiusY(maxSize);
            ellipse.setClip(clipShape);
            double offsetX = ellipse.getCenterX() - clipShape.getRadiusX();
            double offsetY = ellipse.getCenterY() - ellipse.getRadiusY();
            clipShape.relocate(offsetX, offsetY);
            firstFrame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(ellipse.radiusXProperty(), clipShape.getRadiusY()),
                    new KeyValue(clipShape.radiusYProperty(), ellipse.getRadiusX()));
        } else if (shape instanceof Line line) {
            double maxSize = Math.max(Math.abs(line.getEndX() - line.getStartX()), Math.abs(line.getEndY() - line.getStartY()));
            clipShape.setRadiusX(maxSize / 2);
            clipShape.setRadiusY(maxSize);
            clipShape.relocate(clipShape.getRadiusX(), clipShape.getCenterY() / 2);
            line.setClip(clipShape);
            firstFrame = new KeyFrame(
                    Duration.seconds(3),
                    new KeyValue(line.strokeWidthProperty(), maxSize * 2),
                    new KeyValue(clipShape.radiusYProperty(), clipShape.getRadiusY() / 2),
                    new KeyValue(clipShape.radiusXProperty(), clipShape.getRadiusX() / 2)
            );
        }

        Timeline animation = new Timeline(firstFrame);

        animation.playFromStart();
    }
}
